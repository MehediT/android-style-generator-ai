package com.toure.mehedi.style_generator_ai.data.repository

import com.toure.mehedi.style_generator_ai.data.mapper.toDomain
import com.toure.mehedi.style_generator_ai.data.remote.FashionProductService
import com.toure.mehedi.style_generator_ai.domain.model.FashionCategory
import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct
import com.toure.mehedi.style_generator_ai.domain.repository.FashionProductRepository
import javax.inject.Inject

class FashionProductRepositoryImpl @Inject constructor(
    private val service: FashionProductService
) : FashionProductRepository {
    override suspend fun getProducts(): Result<List<FashionProduct>> =
        runCatching { service.getProducts().map { it.toDomain() } }
}
