package com.toure.mehedi.style_generator_ai.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ReplicatePredictionRequestDto(
    val input: ReplicateInputDto
)

data class ReplicateInputDto(
    @SerializedName("human_img") val humanImg: String,
    @SerializedName("garm_img") val garmImg: String,
    val prompt: String
)

data class ReplicatePredictionResponseDto(
    val id: String,
    val status: String,
    val output: List<String>? = null,
    val error: String? = null
)
