package com.toure.mehedi.style_generator_ai.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefaultImageDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    @SerialName("prompt") val prompt: String? = null,
    @SerialName("image_path") val imagePath: String,
    @SerialName("aspect_ratio") val aspectRatio: Float,
    val tags: List<String> = emptyList(),
    val gender: String? = null,
    val style: String? = null,
    @SerialName("is_premium") val isPremium: Boolean = false,
    @SerialName("created_at") val createdAt: Long = 0L
)