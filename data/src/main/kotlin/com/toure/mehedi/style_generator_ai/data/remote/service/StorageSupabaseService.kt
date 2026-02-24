package com.toure.mehedi.style_generator_ai.data.remote.service

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.storage.BucketApi
import io.github.jan.supabase.storage.storage
import javax.inject.Inject

class StorageSupabaseService @Inject constructor(
    private val supabaseClient: SupabaseClient
) {

    fun getUserUploadsBucket(): BucketApi =
        supabaseClient.storage.from(BUCKET_NAME)

    companion object {
        private const val BUCKET_NAME = "user-uploads"
    }
}