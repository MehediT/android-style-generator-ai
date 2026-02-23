package com.toure.mehedi.style_generator_ai.data.di

import com.toure.mehedi.style_generator_ai.data.remote.api.ReplicateApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReplicateModule {

    @Provides
    @Singleton
    fun provideReplicateApiService(retrofit: Retrofit): ReplicateApiService =
        retrofit.create(ReplicateApiService::class.java)
}
