package com.toure.mehedi.style_generator_ai.data.remote.service

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.PostgrestQueryBuilder
import javax.inject.Inject

class TableSupabaseService @Inject constructor(
    private val supabaseClient: SupabaseClient
) {
    fun getFashionProductsTable(): PostgrestQueryBuilder =
        supabaseClient.from(FASHION_PRODUCT_TABLE)

    companion object {

        private const val FASHION_PRODUCT_TABLE = "fashion_product"
    }
}