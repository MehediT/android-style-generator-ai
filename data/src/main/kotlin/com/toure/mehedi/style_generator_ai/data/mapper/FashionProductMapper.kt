package com.toure.mehedi.style_generator_ai.data.mapper

import com.toure.mehedi.style_generator_ai.data.remote.dto.FashionProductDto
import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct
import com.toure.mehedi.style_generator_ai.domain.model.Gender

fun FashionProductDto.toDomain(): FashionProduct = FashionProduct(
    id = id,
    name = name,
    description = description,
    category = category,
    negativePrompt = negativePrompt,
    imageUrl = imagePath,
    aspectRatio = aspectRatio,
    thumbnailUrl = thumbnailUrl,
    tags = tags,
    gender = gender.toDomain(),
    style = style,
    isPremium = isPremium,
    createdAt = createdAt
)

fun String?.toDomain(): Gender = when (this) {
    "men"  -> Gender.MEN
    "women" -> Gender.WOMEN
    "unisex" -> Gender.UNISEX
    else -> Gender.UNKNOWN
}