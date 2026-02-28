package com.toure.mehedi.style_generator_ai.domain.usecase

import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.repository.AuthRepository
import com.toure.mehedi.style_generator_ai.domain.repository.UserImageRepository
import java.util.UUID
import javax.inject.Inject

class UploadUserImageUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userImageRepository: UserImageRepository
) {
    suspend operator fun invoke(imageData: ImageData): Result<String> {
        return try {
            val uid = authRepository.getCurrentUserId()
                .getOrElse { return Result.failure(it) }
            val path = "$uid/${UUID.randomUUID()}.jpg"
            userImageRepository.upload(path, imageData)
        } catch (e: DataException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(DataException.Unknown(e.message ?: "Unknown error", e))
        }
    }
}
