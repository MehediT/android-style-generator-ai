package com.toure.mehedi.style_generator_ai.data.mapper

import com.toure.mehedi.style_generator_ai.data.remote.dto.DefaultImageDto
import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct
import com.toure.mehedi.style_generator_ai.domain.model.Gender

fun DefaultImageDto.toDomain(): FashionProduct = FashionProduct(
    id = id,
    name = name,
    description = description,
    category = category,
    negativePrompt = prompt,
    imageUrl = imagePath,
    aspectRatio = aspectRatio,
    thumbnailUrl = thumbnailPath,
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