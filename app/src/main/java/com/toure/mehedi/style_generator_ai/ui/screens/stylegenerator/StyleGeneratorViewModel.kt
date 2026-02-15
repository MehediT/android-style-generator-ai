package com.toure.mehedi.style_generator_ai.ui.screens.stylegenerator

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class StyleGeneratorUiState(
    val prompt: String = "",
    val isGenerating: Boolean = false,
    val generatedStyle: String? = null
)

@HiltViewModel
class StyleGeneratorViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(StyleGeneratorUiState())
    val uiState: StateFlow<StyleGeneratorUiState> = _uiState.asStateFlow()

    fun updatePrompt(prompt: String) {
        _uiState.value = _uiState.value.copy(prompt = prompt)
    }

    fun generateStyle() {
        // TODO: Implémenter la génération de style avec IA
        _uiState.value = _uiState.value.copy(isGenerating = true)

        // Simulation pour l'instant
        _uiState.value = _uiState.value.copy(
            isGenerating = false,
            generatedStyle = "Style généré pour: ${_uiState.value.prompt}"
        )
    }
}
