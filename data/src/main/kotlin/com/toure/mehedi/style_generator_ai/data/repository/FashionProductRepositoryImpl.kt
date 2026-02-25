package com.toure.mehedi.style_generator_ai.data.repository

import com.toure.mehedi.style_generator_ai.data.mapper.toDomain
import com.toure.mehedi.style_generator_ai.data.remote.dto.DefaultImageDto
import com.toure.mehedi.style_generator_ai.data.remote.service.FashionProductService
import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage
import com.toure.mehedi.style_generator_ai.domain.repository.FashionProductRepository
import javax.inject.Inject

class FashionProductRepositoryImpl @Inject constructor(
    private val service: FashionProductService
) : FashionProductRepository {
    override suspend fun getProducts(): Result<List<DefaultImage>> =
        runCatching {
            service.getProducts().map(DefaultImageDto::toDomain)
        }

    companion object {
        private const val TAG = "FashionProductRepository"
    }
}
