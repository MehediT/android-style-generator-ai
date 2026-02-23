package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.model.TryOnResult
import com.toure.mehedi.style_generator_ai.domain.repository.TryOnRepository
import javax.inject.Inject

class TryOnUseCase @Inject constructor(
    private val repository: TryOnRepository
) {
    suspend operator fun invoke(imageData: ImageData, productId: String): Result<TryOnResult> =
        repository.tryOn(imageData, productId)
}
