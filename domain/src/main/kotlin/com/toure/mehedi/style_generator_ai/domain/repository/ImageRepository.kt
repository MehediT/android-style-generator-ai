package com.toure.mehedi.style_generator_ai.domain.repository

import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage

interface ImageRepository {
    suspend fun getProducts(): Result<List<DefaultImage>>
}
