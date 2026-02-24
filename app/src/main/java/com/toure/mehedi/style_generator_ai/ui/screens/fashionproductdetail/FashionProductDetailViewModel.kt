package com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.usecase.GenerateImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FashionProductDetailUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val generatedImageUrl: String? = null,
    val userPhotoUri: String? = null,
    val productImageUrl: String? = null,
)

@HiltViewModel
class FashionProductDetailViewModel @Inject constructor(
    private val uploadImageUseCase: GenerateImageUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(FashionProductDetailUiState())
    val uiState: StateFlow<FashionProductDetailUiState> = _uiState.asStateFlow()

    fun onImageSelected(
        bytes: ByteArray,
        articleUrl: String,
        prompt: String,
        userPhotoUri: String?,
    ) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null,
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
                _uiState.update { it.copy(isLoading = false, error = error.message) }
            }
        }
    }
}