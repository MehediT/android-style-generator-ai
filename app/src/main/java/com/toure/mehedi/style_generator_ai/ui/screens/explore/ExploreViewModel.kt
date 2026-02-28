package com.toure.mehedi.style_generator_ai.ui.screens.explore

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.toure.mehedi.style_generator_ai.domain.usecase.GetImagesUseCase
import com.toure.mehedi.style_generator_ai.ui.BaseViewModel
import com.toure.mehedi.style_generator_ai.ui.models.AppEvent
import com.toure.mehedi.style_generator_ai.ui.models.AppEventBus
import com.toure.mehedi.style_generator_ai.ui.models.ImageUi
import com.toure.mehedi.style_generator_ai.ui.models.toErrorResId
import com.toure.mehedi.style_generator_ai.ui.models.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ExploreUiState(
    val products: List<ImageUi> = emptyList(),
    val isLoading: Boolean = false,
    val selectedProduct: ImageUi? = null
)

@HiltViewModel
class ExploreViewModel @Inject constructor(
    appEventBus: AppEventBus,
    private val getImages: GetImagesUseCase
) : BaseViewModel(appEventBus) {

    private val _uiState = MutableStateFlow(ExploreUiState())
    val uiState: StateFlow<ExploreUiState> = _uiState.asStateFlow()

    companion object {
        private const val TAG = "ExploreViewModel"
    }

    init {
        loadProducts()
    }

    fun selectProduct(product: ImageUi) {
        _uiState.update { it.copy(selectedProduct = product) }
    }

    private fun loadProducts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getImages()
                .onSuccess { products ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            products = products.map { p -> p.toUiModel() }
                        )
                    }
                }
                .onFailure { error ->
                    Log.e(TAG, "loadProducts error: ${error::class.simpleName} — ${error.message}", error)
                    _uiState.update { it.copy(isLoading = false) }
                    emitEvent(AppEvent.Error(error.toErrorResId()))
                }
        }
    }
}
