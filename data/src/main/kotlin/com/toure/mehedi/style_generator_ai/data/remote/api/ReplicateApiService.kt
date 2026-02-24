package com.toure.mehedi.style_generator_ai.data.remote.api

import com.toure.mehedi.style_generator_ai.data.remote.dto.ReplicatePredictionRequestDto
import com.toure.mehedi.style_generator_ai.data.remote.dto.ReplicatePredictionResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ReplicateApiService {

    @POST("models/google/nano-banana/predictions")
    suspend fun createPrediction(
        @Header("Prefer") prefer: String,
        @Body body: ReplicatePredictionRequestDto
    ): ReplicatePredictionResponseDto

    @GET("predictions/{id}")
    suspend fun getPrediction(
        @Path("id") id: String
    ): ReplicatePredictionResponseDto
}
