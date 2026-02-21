package com.toure.mehedi.style_generator_ai.domain.repository

import com.toure.mehedi.style_generator_ai.domain.model.FashionCategory
import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct

interface FashionProductRepository {
    suspend fun getProducts(): Result<List<FashionProduct>>
}
