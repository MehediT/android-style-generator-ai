package com.toure.mehedi.style_generator_ai.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FashionProductDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    @SerialName("negative_prompt") val negativePrompt: String? = null,
    @SerialName("image_path") val imagePath: String,
    @SerialName("aspect_ratio") val aspectRatio: Float,
    @SerialName("thumbnail_url") val thumbnailUrl: String? = null,
    val tags: List<String> = emptyList(),
    val gender: String? = null,
    val style: String? = null,
    @SerialName("is_premium") val isPremium: Boolean = false,
    @SerialName("created_at") val createdAt: Long = 0L
) {
    companion object {
        val tableName = "fashion_product"
    }
}