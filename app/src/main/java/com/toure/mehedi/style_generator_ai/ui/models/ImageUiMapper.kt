package com.toure.mehedi.style_generator_ai.ui.models

import com.toure.mehedi.style_generator_ai.domain.model.DefaultImage as DomainImage
import com.toure.mehedi.style_generator_ai.domain.model.Gender as DomainGender

fun DomainImage.toUiModel(): ImageUi = ImageUi(
    id = id,
    name = name,
    description = description,
    category = category,
    negativePrompt = prompt,
    imageUrl = imageUrl,
    aspectRatio = aspectRatio,
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
