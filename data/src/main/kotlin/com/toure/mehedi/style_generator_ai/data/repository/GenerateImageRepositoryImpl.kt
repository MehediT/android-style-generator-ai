package com.toure.mehedi.style_generator_ai.data.repository

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.remote.service.ReplicateService
import com.toure.mehedi.style_generator_ai.domain.repository.GenerateImageRepository
import javax.inject.Inject

class GenerateImageRepositoryImpl @Inject constructor(
    private val service: ReplicateService
) : GenerateImageRepository {
    override suspend fun generate(
        humanImageUrl: String,
        garmentImageUrl: String,
        prompt: String
    ): Result<String> =
        runCatching {
            service.generateImage(humanImageUrl, garmentImageUrl, prompt)
        }.also { result ->
            result
                .onSuccess { url -> Log.d(TAG, "generate success: $url") }
                .onFailure { error -> Log.e(TAG, "generate failed", error) }
        }

    companion object {
        private const val TAG = "GenerateImageRepository"
    }
}
