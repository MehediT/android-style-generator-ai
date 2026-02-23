package com.toure.mehedi.style_generator_ai.domain.repository

import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.model.TryOnResult

interface TryOnRepository {
    suspend fun tryOn(imageData: ImageData, productId: String): Result<TryOnResult>
}
