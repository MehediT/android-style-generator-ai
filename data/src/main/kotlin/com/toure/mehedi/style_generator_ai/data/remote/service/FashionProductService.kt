package com.toure.mehedi.style_generator_ai.data.remote.service

import android.util.Log
import com.toure.mehedi.style_generator_ai.data.remote.dto.DefaultImageDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.hours

class FashionProductService @Inject constructor(
    private val tableService: TableSupabaseService,
    private val storageService: StorageSupabaseService
) {
    suspend fun getProducts(): List<DefaultImageDto> =
        withContext(Dispatchers.IO) {
            try {
                val result = tableService.getFashionProductsTable()
                    .select()
                    .decodeList<DefaultImageDto>()
                Log.d(TAG, "Raw DTOs from Supabase (${result.size}): $result")
                result.map { product ->
                    product.copy(
                        imagePath = product.imagePath.pathToUrl(),
                        thumbnailPath = product.thumbnailPath?.pathToUrl()
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Erreur decodeList: ${e::class.simpleName} - ${e.message}", e)
                emptyList()
            }
        }

    companion object {
        private const val TAG = "FashionProductService"
    }

    private suspend fun String.pathToUrl(): String =
        storageService.getImagesBucket().createSignedUrl(this, expiresIn = 1.hours)
}