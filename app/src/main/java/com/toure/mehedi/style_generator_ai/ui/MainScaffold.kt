package com.toure.mehedi.style_generator_ai.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.toure.mehedi.style_generator_ai.navigation.Routes
import com.toure.mehedi.style_generator_ai.ui.components.topbars.DesignSystemTopBar
import com.toure.mehedi.style_generator_ai.ui.components.topbars.HomeTopBar
import com.toure.mehedi.style_generator_ai.ui.components.topbars.SettingsTopBar
import com.toure.mehedi.style_generator_ai.ui.components.topbars.StyleGeneratorTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            when (currentRoute) {
                Routes.Home.route -> HomeTopBar()
                Routes.DesignSystem.route -> DesignSystemTopBar(
                    onNavigateBack = { navController.popBackStack() }
                )
                Routes.StyleGenerator.route -> StyleGeneratorTopBar(
                    onNavigateBack = { navController.popBackStack() }
                )
                Routes.Settings.route -> SettingsTopBar(
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}
