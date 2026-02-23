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
        Log.d(TAG, "Creating prediction — humanImg=$humanImageUrl, garmImg=$garmentImageUrl")

        val prediction = api.createPrediction(
            ReplicatePredictionRequestDto(
                input = ReplicateInputDto(
                    humanImg = humanImageUrl,
                    garmImg = garmentImageUrl,
                    prompt = prompt
                )
            )
        )

        Log.d(TAG, "Prediction created: id=${prediction.id}")
        pollUntilComplete(prediction.id)
    }

    private suspend fun pollUntilComplete(predictionId: String): String {
        while (true) {
            val prediction = api.getPrediction(predictionId)
            Log.d(TAG, "Polling prediction $predictionId — status=${prediction.status}")
            when (prediction.status) {
                "succeeded" -> {
                    val url = prediction.output?.firstOrNull()
                        ?: error("Prediction succeeded but output is empty")
                    Log.d(TAG, "Prediction succeeded: $url")
                    return url
                }
                "failed", "canceled" -> error("Prediction failed: ${prediction.error}")
                else -> delay(POLL_INTERVAL_MS)
            }
        }
    }

    companion object {
        private const val TAG = "ReplicateService"
        private const val POLL_INTERVAL_MS = 2_000L
    }
}
