package com.toure.mehedi.style_generator_ai.domain.usecase

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
        val userUploadedImageUrl = uploadUserImage(imageData)
            .getOrElse { return Result.failure(it) }

        return generateImageRepository.generate(
            garmentImageUrl = userUploadedImageUrl,
            humanImageUrl = userUploadedImageUrl,
            prompt = prompt
        )
    }
}