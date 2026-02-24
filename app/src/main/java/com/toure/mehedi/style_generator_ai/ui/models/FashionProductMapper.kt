package com.toure.mehedi.style_generator_ai.ui.models

import com.toure.mehedi.style_generator_ai.domain.model.FashionProduct as DomainFashionProduct
import com.toure.mehedi.style_generator_ai.domain.model.Gender as DomainGender

fun DomainFashionProduct.toUiModel(): FashionProduct = FashionProduct(
    id = id,
    name = name,
    description = description,
    category = category,
    negativePrompt = negativePrompt,
    imageUrl = imageUrl,
    aspectRatio = aspectRatio,
    thumbnailUrl = thumbnailUrl,
    tags = tags,
    gender = gender?.toUiModel(),
    style = style,
    isPremium = isPremium,
    createdAt = createdAt
)

fun DomainGender.toUiModel(): Gender? = when (this) {
    DomainGender.MEN -> Gender.MEN
    DomainGender.WOMEN -> Gender.WOMEN
    DomainGender.UNISEX -> Gender.UNISEX
    DomainGender.UNKNOWN -> null
}
