package com.toure.mehedi.style_generator_ai.data.remote

import com.toure.mehedi.style_generator_ai.data.remote.dto.FashionProductDto

interface FashionProductService {
    suspend fun getProducts(): List<FashionProductDto> = TODO("Implement when server is ready")

    suspend fun getProductById(id: String): FashionProductDto = TODO("Implement when server is ready")

    suspend fun getProductsByCategory(category: String): List<FashionProductDto> = TODO("Implement when server is ready")
}
