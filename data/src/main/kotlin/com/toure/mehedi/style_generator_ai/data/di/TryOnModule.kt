package com.toure.mehedi.style_generator_ai.data.di

import com.toure.mehedi.style_generator_ai.data.repository.TryOnRepositoryImpl
import com.toure.mehedi.style_generator_ai.domain.repository.TryOnRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TryOnModule {
    @Binds
    @Singleton
    abstract fun bindTryOnRepository(
        impl: TryOnRepositoryImpl
    ): TryOnRepository
}
