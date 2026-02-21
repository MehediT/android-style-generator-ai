package com.toure.mehedi.style_generator_ai.data.remote.dto

data class FashionProductDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val negativePrompt: String? = null,
    val imagePath: String,
    val aspectRatio: Float,
    val thumbnailUrl: String? = null,
    val tags: List<String> = emptyList(),
    val gender: String? = null,
    val style: String? = null,
    val isPremium: Boolean = false,
    val createdAt: Long = 0L
)
