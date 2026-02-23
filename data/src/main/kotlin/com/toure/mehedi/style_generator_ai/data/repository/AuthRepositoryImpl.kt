package com.toure.mehedi.style_generator_ai.data.repository

import com.toure.mehedi.style_generator_ai.domain.repository.AuthRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient
) : AuthRepository {
    override suspend fun ensureSession() {
        if (supabaseClient.auth.currentSessionOrNull() == null) {
            supabaseClient.auth.signInAnonymously()
        }
    }
}
