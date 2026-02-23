package com.toure.mehedi.style_generator_ai.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ReplicatePredictionRequestDto(
    val input: ReplicateInputDto
)

data class ReplicateInputDto(
    val prompt: String,
    @SerializedName("image_input") val imageInput: List<String>,
    @SerializedName("output_format") val outputFormat: String = "jpg"
)

data class ReplicatePredictionResponseDto(
    val id: String,
    val status: String,
    val output: String? = null,
    val error: String? = null,
    val logs: String? = null
)
