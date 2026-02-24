package com.toure.mehedi.style_generator_ai.data.config

import com.toure.mehedi.style_generator_ai.data.BuildConfig

object ReplicateConfig {
    val apiToken: String
        get() = BuildConfig.REPLICATE_API_TOKEN

    fun isConfigured(): Boolean = apiToken.isNotEmpty()

    const val BASE_REPLICATE_URL = "https://api.replicate.com/v1/"
}
