package com.toure.mehedi.style_generator_ai.data.repository

import com.toure.mehedi.style_generator_ai.data.remote.service.StorageSupabaseService
import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.repository.UserImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes

class UserImageRepositoryImpl @Inject constructor(
    private val supabaseService: StorageSupabaseService
) : UserImageRepository {

    override suspend fun upload(path: String, imageData: ImageData): Result<String> =
        withContext(Dispatchers.IO) {
            try {
                val bucket = supabaseService.getUserUploadsBucket()
                bucket.upload(path, imageData.bytes)
                val signedUrl = bucket.createSignedUrl(path, expiresIn = 5.minutes)
                Result.success(signedUrl)
            } catch (e: IOException) {
                Result.failure(DataException.Network(e.message ?: "Network error", e))
            } catch (e: Exception) {
                Result.failure(DataException.Storage(e.message ?: "Storage error", e))
            }
        }
}
