package com.toure.mehedi.style_generator_ai.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.toure.mehedi.style_generator_ai.navigation.Routes
import com.toure.mehedi.style_generator_ai.ui.components.topbars.ImageDetailTopBar
import com.toure.mehedi.style_generator_ai.ui.components.topbars.GeneratedImageTopBar
import com.toure.mehedi.style_generator_ai.ui.components.topbars.HomeTopBar

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
                Routes.Explore.route -> HomeTopBar()
                Routes.ImageDetail.route -> ImageDetailTopBar(
                    onNavigateBack = { navController.navigateUp() }
                )
                Routes.GeneratedImage.route -> GeneratedImageTopBar(
                    onNavigateBack = { navController.navigateUp() }
                )
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}
