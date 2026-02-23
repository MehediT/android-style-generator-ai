package com.toure.mehedi.style_generator_ai.data.di

import com.toure.mehedi.style_generator_ai.data.config.ReplicateConfig
import com.toure.mehedi.style_generator_ai.data.config.ReplicateConfig.BASE_REPLICATE_URL
import com.toure.mehedi.style_generator_ai.data.config.SupabaseAppConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.storage.Storage
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {
    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        if (!SupabaseAppConfig.isSupabaseConfigured())
            throw IllegalStateException("Supabase is not configured")
        return createSupabaseClient(
            supabaseUrl = SupabaseAppConfig.supabaseUrl,
            supabaseKey = SupabaseAppConfig.supabaseAnonKey
        ) {
            install(Auth)
            install(Postgrest)
            install(Realtime)
            install(Storage)
        }
    }

    @Provides
    @Singleton
    fun provideReplicateOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer ${ReplicateConfig.apiToken}")
                        .addHeader("Content-Type", "application/json")
                        .build()
                )
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    @Provides
    @Singleton
    fun provideReplicateRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_REPLICATE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}
