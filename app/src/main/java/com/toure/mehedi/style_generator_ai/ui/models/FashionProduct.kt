package com.toure.mehedi.style_generator_ai.ui.models

data class FashionProduct(
    val id: String,
    val name: String,
    val description: String,
    val category: FashionCategory,
    val negativePrompt: String? = null,
    val imageUrl: String,
    val aspectRatio: Float,
    val thumbnailUrl: String? = null,
    val tags: List<String> = emptyList(),
    val gender: Gender? = null,
    val style: String? = null,
    val color: String? = null,
    val isPremium: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)