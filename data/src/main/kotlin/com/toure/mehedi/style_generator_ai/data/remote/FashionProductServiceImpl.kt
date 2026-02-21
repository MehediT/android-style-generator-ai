package com.toure.mehedi.style_generator_ai.data.remote

import com.toure.mehedi.style_generator_ai.data.remote.dto.FashionProductDto
import javax.inject.Inject

class FashionProductServiceImpl @Inject constructor() : FashionProductService {
    override suspend fun getProducts(): List<FashionProductDto> = TODO("Implement when server is ready")
}
