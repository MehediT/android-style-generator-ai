package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct
import com.toure.mehedi.style_generator_ai.domain.repository.FashionProductRepository
import javax.inject.Inject

class GetFashionProductsUseCase @Inject constructor(
    private val repository: FashionProductRepository
) {
    suspend operator fun invoke(): Result<List<FashionProduct>> = repository.getProducts()
}
