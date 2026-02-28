package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.repository.AuthRepository
import javax.inject.Inject

class EnsureAnonymousAuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() {
        try {
            repository.ensureSession()
        } catch (e: DataException) {
            throw e
        } catch (e: Exception) {
            throw DataException.Unknown(e.message ?: "Unknown error", e)
        }
    }
}