package com.toure.mehedi.style_generator_ai.data.remote.service

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.PostgrestQueryBuilder
import javax.inject.Inject

class TableSupabaseService @Inject constructor(
    private val supabaseClient: SupabaseClient
) {
    fun getFashionProductsTable(): PostgrestQueryBuilder =
        supabaseClient.from(DEFAULT_IMAGES_TABLE)

    companion object {
        private const val DEFAULT_IMAGES_TABLE = "default_images"
    }
}