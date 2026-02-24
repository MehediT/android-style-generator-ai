package com.toure.mehedi.style_generator_ai.domain.repository

import com.toure.mehedi.style_generator_ai.domain.model.ImageData

interface UserImageRepository {
    suspend fun upload(path: String, imageData: ImageData): Result<String>
}
