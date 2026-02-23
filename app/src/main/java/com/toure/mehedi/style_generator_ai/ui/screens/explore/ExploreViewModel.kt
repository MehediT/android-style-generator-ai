package com.toure.mehedi.style_generator_ai.ui.screens.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toure.mehedi.style_generator_ai.domain.usecase.GetFashionProductsUseCase
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.models.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ExploreUiState(
    val products: List<FashionProduct> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedProduct: FashionProduct? = null
)

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val getFashionProducts: GetFashionProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ExploreUiState())
    val uiState: StateFlow<ExploreUiState> = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    fun selectProduct(product: FashionProduct) {
        _uiState.update { it.copy(selectedProduct = product) }
    }

    private fun loadProducts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            getFashionProducts()
                .onSuccess { products ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            products = products.map { p -> p.toUiModel() }
                        )
                    }
                }
                .onFailure { error ->
                    _uiState.update { it.copy(isLoading = false, error = error.message) }
                }
        }
    }
}
