package com.toure.mehedi.style_generator_ai.data.remote.service

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.PostgrestQueryBuilder
import io.github.jan.supabase.storage.BucketApi
import io.github.jan.supabase.storage.storage
import javax.inject.Inject

class TableSupabaseService @Inject constructor(
    private val supabaseClient: SupabaseClient
) {
    fun getFashionProductsTable(): PostgrestQueryBuilder =
        supabaseClient.from(FASHION_PRODUCTS_TABLE)

    companion object {

        private const val FASHION_PRODUCTS_TABLE = "fashion_products"
    }
}