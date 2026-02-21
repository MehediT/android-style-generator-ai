package com.toure.mehedi.style_generator_ai.data.config

import com.toure.mehedi.style_generator_ai.BuildConfig

object AppConfig {
    val supabaseUrl: String
        get() = BuildConfig.SUPABASE_URL

    val supabaseAnonKey: String
        get() = BuildConfig.SUPABASE_ANON_KEY

    fun isSupabaseConfigured(): Boolean =
        supabaseUrl.isNotEmpty() && supabaseAnonKey.isNotEmpty()
}