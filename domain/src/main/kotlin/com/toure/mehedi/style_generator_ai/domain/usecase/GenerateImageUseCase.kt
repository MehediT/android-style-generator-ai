package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.repository.GenerateImageRepository
import javax.inject.Inject

class GenerateImageUseCase @Inject constructor(
    private val uploadUserImage: UploadUserImageUseCase,
    private val generateImageRepository: GenerateImageRepository
) {
    suspend operator fun invoke(
        imageData: ImageData,
        articleUrl: String,
        prompt: String
    ): Result<String> {
        return try {
            val userUploadedImageUrl = uploadUserImage(imageData)
                .getOrElse { return Result.failure(it) }

            generateImageRepository.generate(
                garmentImageUrl = userUploadedImageUrl,
                humanImageUrl = userUploadedImageUrl,
                prompt = prompt
            )
        } catch (e: DataException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(DataException.Unknown(e.message ?: "Unknown error", e))
        }
    }
}