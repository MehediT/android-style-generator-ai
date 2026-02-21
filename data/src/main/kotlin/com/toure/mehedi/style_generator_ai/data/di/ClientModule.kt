package com.toure.mehedi.style_generator_ai.data.di

import com.toure.mehedi.style_generator_ai.data.remote.service.FashionProductService
import com.toure.mehedi.style_generator_ai.data.repository.FashionProductRepositoryImpl
import com.toure.mehedi.style_generator_ai.domain.repository.FashionProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.createSupabaseClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ClientModule {

}
