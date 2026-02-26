package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage
import com.toure.mehedi.style_generator_ai.domain.repository.ImageRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(): Result<List<DefaultImage>> {
        return repository.getProducts()
    }
}
