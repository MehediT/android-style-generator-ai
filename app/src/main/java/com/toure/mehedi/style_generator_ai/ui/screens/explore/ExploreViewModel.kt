package com.toure.mehedi.style_generator_ai.ui.screens.explore

import androidx.lifecycle.ViewModel
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.models.sampleFashionProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class ExploreUiState(
    val appTitle: String = "Android Style Generator AI",
    val welcomeMessage: String = "Bienvenue ! Générez et explorez des design systems Android",
    val products: List<FashionProduct> = sampleFashionProducts.shuffled()
)

@HiltViewModel
class ExploreViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(ExploreUiState())
    val uiState: StateFlow<ExploreUiState> = _uiState.asStateFlow()
}
