package com.toure.mehedi.style_generator_ai.data.repository

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.remote.service.ImageUploadService
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.repository.ImageUploadRepository
import javax.inject.Inject

class ImageUploadRepositoryImpl @Inject constructor(
    private val service: ImageUploadService
) : ImageUploadRepository {
    override suspend fun uploadImage(imageData: ImageData): Result<String> =
        runCatching {
            service.uploadImage(imageData.bytes)
        }.also { result ->
            result
                .onSuccess { url -> Log.d(TAG, "uploadImage success: $url") }
                .onFailure { error -> Log.e(TAG, "uploadImage failed", error) }
        }

    companion object {
        private const val TAG = "ImageUploadRepository"
    }
}
