package com.toure.mehedi.style_generator_ai.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.toure.mehedi.style_generator_ai.ui.screens.home.components.NavigationCard

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    onNavigateToDesignSystem: () -> Unit,
    onNavigateToStyleGenerator: () -> Unit,
    onNavigateToSettings: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = uiState.welcomeMessage,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Card Design System
        NavigationCard(
            title = "Design System",
            description = "Explorez les composants et tokens du design system",
            icon = Icons.Filled.Build,
            onClick = onNavigateToDesignSystem
        )

        // Card Style Generator
        NavigationCard(
            title = "Générateur de Style",
            description = "Générez des styles avec l'IA",
            icon = Icons.Filled.Star,
            onClick = onNavigateToStyleGenerator
        )

        // Card Settings
        NavigationCard(
            title = "Paramètres",
            description = "Configurez vos préférences",
            icon = Icons.Filled.Settings,
            onClick = onNavigateToSettings
        )
    }
}
