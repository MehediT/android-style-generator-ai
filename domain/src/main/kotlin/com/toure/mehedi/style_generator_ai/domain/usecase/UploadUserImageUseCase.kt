package com.toure.mehedi.style_generator_ai.domain.usecase

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
        val uid = authRepository.getCurrentUserId()
            .getOrElse { return Result.failure(it) }
        val path = "$uid/${UUID.randomUUID()}.jpg"
        return userImageRepository.upload(path, imageData)
    }
}
