package com.toure.mehedi.style_generator_ai.domain.repository

interface GenerateImageRepository {
    suspend fun generate(
        humanImageUrl: String,
        garmentImageUrl: String,
        prompt: String
    ): Result<String>
}
