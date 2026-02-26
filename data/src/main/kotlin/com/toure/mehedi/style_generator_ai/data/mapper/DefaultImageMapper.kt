package com.toure.mehedi.style_generator_ai.data.mapper

import com.toure.mehedi.style_generator_ai.data.remote.dto.DefaultImageDto
import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage
import com.toure.mehedi.style_generator_ai.domain.model.Gender

fun DefaultImageDto.toDomain(): DefaultImage = DefaultImage(
    id = id,
    name = name,
    description = description,
    category = category,
    prompt = prompt,
    imageUrl = imagePath,
    aspectRatio = aspectRatio,
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