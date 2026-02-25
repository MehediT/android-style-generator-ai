package com.toure.mehedi.style_generator_ai.domain.repository

import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage

interface FashionProductRepository {
    suspend fun getProducts(): Result<List<DefaultImage>>
}
