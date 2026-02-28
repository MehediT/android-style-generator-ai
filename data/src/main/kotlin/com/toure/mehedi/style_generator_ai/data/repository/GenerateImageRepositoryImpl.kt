package com.toure.mehedi.style_generator_ai.data.repository

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.remote.service.ReplicateService
import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.repository.GenerateImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GenerateImageRepositoryImpl @Inject constructor(
    private val service: ReplicateService
) : GenerateImageRepository {

    override suspend fun generate(
        humanImageUrl: String,
        garmentImageUrl: String,
        prompt: String
    ): Result<String> = withContext(Dispatchers.IO) {
        try {
            val url = service.generateImage(humanImageUrl, garmentImageUrl, prompt)
            Log.d(TAG, "generate success: $url")
            Result.success(url)
        } catch (e: HttpException) {
            Log.e(TAG, "generate HTTP error ${e.code()}", e)
            Result.failure(DataException.Http(e.code(), e.message ?: "HTTP error"))
        } catch (e: IOException) {
            Log.e(TAG, "generate network error", e)
            Result.failure(DataException.Network(e.message ?: "Network error", e))
        } catch (e: Exception) {
            Log.e(TAG, "generate failed", e)
            Result.failure(DataException.Unknown(e.message ?: "Unknown error", e))
        }
    }

    companion object {
        private const val TAG = "GenerateImageRepository"
    }
}
