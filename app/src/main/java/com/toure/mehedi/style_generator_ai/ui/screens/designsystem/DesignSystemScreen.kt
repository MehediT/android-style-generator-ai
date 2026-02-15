package com.toure.mehedi.style_generator_ai.ui.screens.designsystem

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.toure.mehedi.style_generator_ai.ui.showcase.DesignSystemShowcase

@Composable
fun DesignSystemScreen(
    paddingValues: PaddingValues,
    viewModel: DesignSystemViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.padding(paddingValues)) {
        DesignSystemShowcase()
    }
}
