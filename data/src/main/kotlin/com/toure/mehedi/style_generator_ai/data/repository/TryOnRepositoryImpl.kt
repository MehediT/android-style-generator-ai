package com.toure.mehedi.style_generator_ai.data.repository

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.remote.service.TryOnServiceApi
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.model.TryOnResult
import com.toure.mehedi.style_generator_ai.domain.repository.TryOnRepository
import javax.inject.Inject

class TryOnRepositoryImpl @Inject constructor(
    private val service: TryOnServiceApi
) : TryOnRepository {
    override suspend fun tryOn(imageData: ImageData, productId: String): Result<TryOnResult> =
        runCatching {
            val resultImageUrl = service.tryOn(imageData.bytes, productId)
            TryOnResult(resultImageUrl = resultImageUrl)
        }.also { result ->
            result
                .onSuccess { Log.d(TAG, "tryOn success: $it") }
                .onFailure { Log.e(TAG, "tryOn failed", it) }
        }

    companion object {
        private const val TAG = "TryOnRepository"
    }
}
