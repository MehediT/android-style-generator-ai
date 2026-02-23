package com.toure.mehedi.style_generator_ai.data.remote.service

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.remote.api.ReplicateApiService
import com.toure.mehedi.style_generator_ai.data.remote.dto.ReplicateInputDto
import com.toure.mehedi.style_generator_ai.data.remote.dto.ReplicatePredictionRequestDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReplicateService @Inject constructor(
    private val api: ReplicateApiService
) {
    suspend fun generateImage(
        humanImageUrl: String,
        garmentImageUrl: String,
        prompt: String
    ): String = withContext(Dispatchers.IO) {
        Log.d(TAG, "Creating prediction — images=$humanImageUrl, $garmentImageUrl")

        val prediction = api.createPrediction(
            prefer = "wait",
            body = ReplicatePredictionRequestDto(
                input = ReplicateInputDto(
                    prompt = prompt,
                    imageInput = listOf(humanImageUrl, garmentImageUrl)
                )
            )
        )

        Log.d(TAG, "Prediction id=${prediction.id} status=${prediction.status}")

        when (prediction.status) {
            "succeeded" -> prediction.output
                ?: error("Prediction succeeded but output is empty")
            "failed", "canceled" -> {
                Log.e(TAG, "Prediction ${prediction.id} failed — error=${prediction.error} logs=${prediction.logs}")
                error("Prediction failed: ${prediction.error}")
            }
            else -> pollUntilComplete(prediction.id)
        }
    }

    private suspend fun pollUntilComplete(predictionId: String): String {
        while (true) {
            val prediction = api.getPrediction(predictionId)
            Log.d(TAG, "Polling $predictionId — status=${prediction.status}")
            when (prediction.status) {
                "succeeded" -> {
                    val url = prediction.output
                        ?: error("Prediction succeeded but output is empty")
                    Log.d(TAG, "Prediction succeeded: $url")
                    return url
                }
                "failed", "canceled" -> {
                    Log.e(TAG, "Prediction ${prediction.id} failed — error=${prediction.error} logs=${prediction.logs}")
                    error("Prediction failed: ${prediction.error}")
                }
                else -> delay(POLL_INTERVAL_MS)
            }
        }
    }

    companion object {
        private const val TAG = "ReplicateService"
        private const val POLL_INTERVAL_MS = 2_000L
    }
}
