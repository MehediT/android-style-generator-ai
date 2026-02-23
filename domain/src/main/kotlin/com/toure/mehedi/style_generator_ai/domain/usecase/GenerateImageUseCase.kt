package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.repository.ImageUploadRepository
import javax.inject.Inject

class GenerateImageUseCase @Inject constructor(
    private val repository: ImageUploadRepository
) {
    suspend operator fun invoke(imageData: ImageData): Result<String> =
        repository.uploadImage(imageData)
}

object SampleToReplace{
    const val personImageUrl = "https://picsum.photos/seed/picsum/200/300"
    const val promptModel = "Take the clothing item from the first image and put it on the person in the second image. " +
            "Keep the person's pose, skin tone, and facial features exactly as they are." +
            "Make the clothing fit naturally on the body with realistic lighting and shadows matching the scene."
}
