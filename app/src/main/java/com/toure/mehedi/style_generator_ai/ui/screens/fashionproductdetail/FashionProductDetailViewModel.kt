package com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toure.mehedi.style_generator_ai.domain.model.ImageData
import com.toure.mehedi.style_generator_ai.domain.usecase.TryOnUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FashionProductDetailUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val resultImageUrl: String? = null
)

@HiltViewModel
class FashionProductDetailViewModel @Inject constructor(
    private val tryOnUseCase: TryOnUseCase,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow(FashionProductDetailUiState())
    val uiState: StateFlow<FashionProductDetailUiState> = _uiState.asStateFlow()

    fun onImageSelected(uri: Uri, productId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            val bytes = context.contentResolver.openInputStream(uri)?.use { it.readBytes() }
                ?: byteArrayOf()
            tryOnUseCase(ImageData(bytes), productId)
                .onSuccess { result ->
                    _uiState.update { it.copy(isLoading = false, resultImageUrl = result.resultImageUrl) }
                }
                .onFailure { error ->
                    _uiState.update { it.copy(isLoading = false, error = error.message) }
                }
        }
    }
}
