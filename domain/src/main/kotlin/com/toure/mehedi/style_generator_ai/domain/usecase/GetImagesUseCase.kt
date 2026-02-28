package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage
import com.toure.mehedi.style_generator_ai.domain.repository.ImageRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(): Result<List<DefaultImage>> {
        return try {
            repository.getProducts()
        } catch (e: DataException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(DataException.Unknown(e.message ?: "Unknown error", e))
        }
    }
}