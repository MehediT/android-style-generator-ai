package com.toure.mehedi.style_generator_ai.data.remote

import com.toure.mehedi.style_generator_ai.data.remote.dto.FashionProductDto

interface FashionProductService {
    suspend fun getProducts(): List<FashionProductDto>
}
