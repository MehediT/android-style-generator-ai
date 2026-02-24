package com.toure.mehedi.style_generator_ai.data.repository

import io.github.jan.supabase.storage.BucketApi

interface StorageRepository {
    fun getUserUploadsBucket(): BucketApi
}
