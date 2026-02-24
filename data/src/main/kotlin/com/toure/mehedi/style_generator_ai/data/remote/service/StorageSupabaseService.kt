package com.toure.mehedi.style_generator_ai.data.remote.service

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.storage.BucketApi
import io.github.jan.supabase.storage.storage
import javax.inject.Inject

class StorageSupabaseService @Inject constructor(
    private val supabaseClient: SupabaseClient
) {

    fun getUserUploadsBucket(): BucketApi =
        supabaseClient.storage.from(USER_UPLOADS_BUCKET)

    fun getImagesBucket(): BucketApi =
        supabaseClient.storage.from(IMAGES_BUCKET)

    companion object {
        const val IMAGES_BUCKET = "fashion_product"
        private const val USER_UPLOADS_BUCKET = "user-uploads"
    }
}