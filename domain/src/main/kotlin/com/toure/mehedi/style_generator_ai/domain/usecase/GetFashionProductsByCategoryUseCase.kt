package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.model.FashionCategory
import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct
import com.toure.mehedi.style_generator_ai.domain.repository.FashionProductRepository
import javax.inject.Inject

class GetFashionProductsByCategoryUseCase @Inject constructor(
    private val repository: FashionProductRepository
) {
    suspend operator fun invoke(category: FashionCategory): Result<List<FashionProduct>> =
        repository.getProductsByCategory(category)
}
