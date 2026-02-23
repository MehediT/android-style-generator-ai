package com.toure.mehedi.style_generator_ai.data.remote.service

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.remote.dto.FashionProductDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.hours

class FashionProductService @Inject constructor(
    private val supabase: SupabaseClient
) {
    suspend fun getProducts(): List<FashionProductDto> =
        withContext(Dispatchers.IO) {
            supabase.from(FashionProductDto.tableName)
                .select()
                .decodeList<FashionProductDto>()
                .also { raw -> Log.d(TAG, "Raw DTOs from Supabase (${raw.size}): $raw") }
                .map { product ->
                    product.copy(
                        imagePath = product.imagePath.pathToUrl(),
                        thumbnailUrl = product.thumbnailUrl?.pathToUrl()
                    )
                }
        }

    companion object {
        private const val TAG = "FashionProductService"
    }

    private suspend fun String.pathToUrl(): String =
        supabase.storage.from(FashionProductDto.storageBucket)
            .createSignedUrl(this, expiresIn = 1.hours)

}