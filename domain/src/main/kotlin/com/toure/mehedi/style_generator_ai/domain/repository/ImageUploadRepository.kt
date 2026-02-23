package com.toure.mehedi.style_generator_ai.domain.repository

import com.toure.mehedi.style_generator_ai.domain.model.ImageData

interface ImageUploadRepository {
    suspend fun uploadImage(imageData: ImageData): Result<String>
}
