package com.toure.mehedi.style_generator_ai.data.repository

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.mapper.toDomain
import com.toure.mehedi.style_generator_ai.data.remote.dto.FashionProductDto
import com.toure.mehedi.style_generator_ai.data.remote.service.FashionProductService
import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct
import com.toure.mehedi.style_generator_ai.domain.repository.FashionProductRepository
import javax.inject.Inject

class FashionProductRepositoryImpl @Inject constructor(
    private val service: FashionProductService
) : FashionProductRepository {
    override suspend fun getProducts(): Result<List<FashionProduct>> =
        runCatching {
            service.getProducts().map(FashionProductDto::toDomain)
        }.also { result ->
            result
                .onSuccess { products ->
                    Log.d(TAG, "getProducts success (${products.size} items): $products")
                }
                .onFailure { error ->
                    Log.e(TAG, "getProducts failed", error)
                }
        }

    companion object {
        private const val TAG = "FashionProductRepository"
    }
}
