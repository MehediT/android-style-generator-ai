package com.toure.mehedi.style_generator_ai.domain.model

data class FashionProduct(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val negativePrompt: String? = null,
    val imageUrl: String,
    val aspectRatio: Float,
    val thumbnailUrl: String? = null,
    val tags: List<String> = emptyList(),
    val gender: Gender? = null,
    val style: String? = null,
    val isPremium: Boolean = false,
    val createdAt: Long = 0L
)
