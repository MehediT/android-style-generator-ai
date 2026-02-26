package com.toure.mehedi.style_generator_ai.data.repository

import com.toure.mehedi.style_generator_ai.data.mapper.toDomain
import com.toure.mehedi.style_generator_ai.data.remote.dto.DefaultImageDto
import com.toure.mehedi.style_generator_ai.data.remote.service.ImageService
import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage
import com.toure.mehedi.style_generator_ai.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val service: ImageService
) : ImageRepository {
    override suspend fun getProducts(): Result<List<DefaultImage>> =
        runCatching {
            service.getProducts().map(DefaultImageDto::toDomain)
        }

    companion object {
        private const val TAG = "ImageRepository"
    }
}
