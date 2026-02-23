package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.repository.GenerateImageRepository
import com.toure.mehedi.style_generator_ai.domain.repository.ImageUploadRepository
import javax.inject.Inject

class GenerateImageUseCase @Inject constructor(
    private val imageUploadRepository: ImageUploadRepository,
    private val generateImageRepository: GenerateImageRepository
) {
    suspend operator fun invoke(imageData: ImageData): Result<String> {
        val garmentImageUrl = imageUploadRepository.uploadImage(imageData)
            .getOrElse { return Result.failure(it) }
        return generateImageRepository.generate(
            garmentImageUrl = garmentImageUrl,
            humanImageUrl = SampleToReplace.personImageUrl,
            prompt = SampleToReplace.promptModel
        )
    }
}

object SampleToReplace {
    const val personImageUrl = "https://tmpfiles.org/dl/25723136/test2.jpg"
    const val promptModel = "Take this pull item from this image and put it on the person" +
            "Keep the person's pose, skin tone, and facial features exactly as they are." +
            "Make the clothing fit naturally on the body with realistic lighting and shadows matching the scene."
}
