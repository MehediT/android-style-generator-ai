package com.toure.mehedi.style_generator_ai.data.remote.service

import com.toure.mehedi.style_generator_ai.data.remote.dto.FashionProductDto
import javax.inject.Inject

class FashionProductService @Inject constructor() {
    suspend fun getProducts(): List<FashionProductDto> = TODO("Implement when server is ready")
}