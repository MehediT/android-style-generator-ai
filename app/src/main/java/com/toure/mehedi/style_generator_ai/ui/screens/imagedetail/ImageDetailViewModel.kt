package com.toure.mehedi.style_generator_ai.ui.screens.imagedetail

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.toure.mehedi.style_generator_ai.domain.exception.DomainException
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.usecase.GenerateImageUseCase
import com.toure.mehedi.style_generator_ai.ui.BaseViewModel
import com.toure.mehedi.style_generator_ai.ui.models.AppEvent
import com.toure.mehedi.style_generator_ai.ui.models.AppEventBus
import com.toure.mehedi.style_generator_ai.ui.models.toErrorResId
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ImageDetailUiState(
    val isLoading: Boolean = false,
    val generatedImageUrl: String? = null,
    val userPhotoUri: String? = null,
    val productImageUrl: String? = null,
)

@HiltViewModel
class ImageDetailViewModel @Inject constructor(
    appEventBus: AppEventBus,
    @ApplicationContext private val context: Context,
    private val uploadImageUseCase: GenerateImageUseCase,
) : BaseViewModel(appEventBus) {

    private val _uiState = MutableStateFlow(ImageDetailUiState())
    val uiState: StateFlow<ImageDetailUiState> = _uiState.asStateFlow()

    private var generationJob: Job? = null

    companion object {
        private const val TAG = "ImageDetailViewModel"
    }

    fun cancelGeneration() {
        generationJob?.cancel()
        generationJob = null
        _uiState.update { it.copy(isLoading = false) }
    }

    fun onImageSelected(
        bytes: ByteArray,
        articleUrl: String,
        prompt: String,
        userPhotoUri: String?,
    ) {
        if (bytes.isEmpty()) {
            Log.e(TAG, "onImageSelected: bytes are empty, aborting")
            emitEvent(AppEvent.Error(context.getString(DomainException.Validation("").toErrorResId())))
            return
        }

        generationJob = viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    userPhotoUri = userPhotoUri,
                    productImageUrl = articleUrl,
                )
            }
            val imageData = ImageData(bytes)

            uploadImageUseCase(
                imageData = imageData, articleUrl = articleUrl, prompt = prompt
            ).onSuccess { url ->
                _uiState.update { it.copy(isLoading = false, generatedImageUrl = url) }
            }.onFailure { error ->
                Log.e(TAG, "onImageSelected error: ${error::class.simpleName} — ${error.message}", error)
                _uiState.update { it.copy(isLoading = false) }
                emitEvent(AppEvent.Error(context.getString(error.toErrorResId())))
            }
        }
    }
}
