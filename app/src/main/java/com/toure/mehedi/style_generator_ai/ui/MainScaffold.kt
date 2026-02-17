package com.toure.mehedi.style_generator_ai.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.toure.mehedi.style_generator_ai.navigation.Routes
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
                Routes.Home.route -> HomeTopBar()
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}
