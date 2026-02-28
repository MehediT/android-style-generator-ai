package com.toure.mehedi.style_generator_ai.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.toure.mehedi.style_generator_ai.navigation.Routes
import com.toure.mehedi.style_generator_ai.ui.components.AnimatedEventToast
import com.toure.mehedi.style_generator_ai.ui.components.topbars.ImageDetailTopBar
import com.toure.mehedi.style_generator_ai.ui.components.topbars.GeneratedImageTopBar
import com.toure.mehedi.style_generator_ai.ui.components.topbars.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    navController: NavHostController,
    viewModel: AppViewModel,
    content: @Composable (PaddingValues) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val events by viewModel.events.collectAsState()
    val currentEvent = events.firstOrNull()

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
        Box(Modifier.fillMaxSize()) {
            content(paddingValues)
            AnimatedEventToast(
                event = currentEvent,
                onDismiss = { currentEvent?.let { viewModel.dismissEvent(it) } },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
