package com.toure.mehedi.style_generator_ai.data.di

import com.toure.mehedi.style_generator_ai.data.repository.AuthRepositoryImpl
import com.toure.mehedi.style_generator_ai.data.repository.FashionProductRepositoryImpl
import com.toure.mehedi.style_generator_ai.data.repository.GenerateImageRepositoryImpl
import com.toure.mehedi.style_generator_ai.data.repository.ImageUploadRepositoryImpl
import com.toure.mehedi.style_generator_ai.data.repository.UserImageRepositoryImpl
import com.toure.mehedi.style_generator_ai.domain.repository.AuthRepository
import com.toure.mehedi.style_generator_ai.domain.repository.FashionProductRepository
import com.toure.mehedi.style_generator_ai.domain.repository.GenerateImageRepository
import com.toure.mehedi.style_generator_ai.domain.repository.ImageUploadRepository
import com.toure.mehedi.style_generator_ai.domain.repository.UserImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFashionProductRepository(
        impl: FashionProductRepositoryImpl
    ): FashionProductRepository

    @Binds
    @Singleton
    abstract fun bindGenerateImageRepository(
        impl: GenerateImageRepositoryImpl
    ): GenerateImageRepository

    @Binds
    @Singleton
    abstract fun bindImageUploadRepository(
        impl: ImageUploadRepositoryImpl
    ): ImageUploadRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository
}
