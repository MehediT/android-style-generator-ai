package com.toure.mehedi.style_generator_ai.data.repository

import com.toure.mehedi.style_generator_ai.data.mapper.toDomain
import com.toure.mehedi.style_generator_ai.data.remote.dto.DefaultImageDto
import com.toure.mehedi.style_generator_ai.data.remote.service.ImageService
import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage
import com.toure.mehedi.style_generator_ai.domain.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import java.io.IOException
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val service: ImageService
) : ImageRepository {

    override suspend fun getProducts(): Result<List<DefaultImage>> = withContext(Dispatchers.IO) {
        try {
            Result.success(service.getProducts().map(DefaultImageDto::toDomain))
        } catch (e: SerializationException) {
            Result.failure(DataException.Serialization(e.message ?: "Serialization error", e))
        } catch (e: IOException) {
            Result.failure(DataException.Network(e.message ?: "Network error", e))
        } catch (e: Exception) {
            Result.failure(DataException.Unknown(e.message ?: "Unknown error", e))
        }
    }

    companion object {
        private const val TAG = "ImageRepository"
    }
}
