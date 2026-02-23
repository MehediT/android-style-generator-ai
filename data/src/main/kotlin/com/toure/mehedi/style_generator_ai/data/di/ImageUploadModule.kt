package com.toure.mehedi.style_generator_ai.data.di

import com.toure.mehedi.style_generator_ai.data.repository.ImageUploadRepositoryImpl
import com.toure.mehedi.style_generator_ai.domain.repository.ImageUploadRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ImageUploadModule {
    @Binds
    @Singleton
    abstract fun bindImageUploadRepository(
        impl: ImageUploadRepositoryImpl
    ): ImageUploadRepository
}
