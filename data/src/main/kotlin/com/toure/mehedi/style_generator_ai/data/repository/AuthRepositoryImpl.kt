package com.toure.mehedi.style_generator_ai.data.repository

import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.exception.DomainException
import com.toure.mehedi.style_generator_ai.domain.repository.AuthRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient
) : AuthRepository {

    override suspend fun ensureSession() {
        withContext(Dispatchers.IO) {
            try {
                if (supabaseClient.auth.currentSessionOrNull() == null) {
                    supabaseClient.auth.signInAnonymously()
                }
            } catch (e: IOException) {
                throw DataException.Network(e.message ?: "Network error", e)
            } catch (e: Exception) {
                throw DataException.Unknown(e.message ?: "Unknown error", e)
            }
        }
    }

    override suspend fun getCurrentUserId(): Result<String> = withContext(Dispatchers.IO) {
        try {
            val id = supabaseClient.auth.currentSessionOrNull()?.user?.id
                ?: return@withContext Result.failure(DomainException.Unauthorized("No active session"))
            Result.success(id)
        } catch (e: IOException) {
            Result.failure(DataException.Network(e.message ?: "Network error", e))
        } catch (e: Exception) {
            Result.failure(DataException.Unknown(e.message ?: "Unknown error", e))
        }
    }
}
