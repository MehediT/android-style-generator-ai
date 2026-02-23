package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.repository.ImageUploadRepository
import javax.inject.Inject

class UploadImageUseCase @Inject constructor(
    private val repository: ImageUploadRepository
) {
    suspend operator fun invoke(imageData: ImageData): Result<String> =
        repository.uploadImage(imageData)
}
