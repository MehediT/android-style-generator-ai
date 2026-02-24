package com.toure.mehedi.style_generator_ai.domain.repository

interface AuthRepository {
    suspend fun ensureSession()
}
