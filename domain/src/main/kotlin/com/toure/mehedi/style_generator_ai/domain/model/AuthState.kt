package com.toure.mehedi.style_generator_ai.domain.model

sealed class AuthState {
    data object Loading : AuthState()
    data object Authenticated : AuthState()
    data class Error(val message: String) : AuthState()
}