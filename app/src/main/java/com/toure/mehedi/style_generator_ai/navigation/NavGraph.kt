package com.toure.mehedi.style_generator_ai.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toure.mehedi.style_generator_ai.ui.screens.home.HomeScreen
import com.toure.mehedi.style_generator_ai.ui.screens.designsystem.DesignSystemScreen
import com.toure.mehedi.style_generator_ai.ui.screens.stylegenerator.StyleGeneratorScreen
import com.toure.mehedi.style_generator_ai.ui.screens.settings.SettingsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    startDestination: String = Routes.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Routes.Home.route) {
            HomeScreen(
                paddingValues = paddingValues,
                onNavigateToDesignSystem = {
                    navController.navigate(Routes.DesignSystem.route)
                },
                onNavigateToStyleGenerator = {
                    navController.navigate(Routes.StyleGenerator.route)
                },
                onNavigateToSettings = {
                    navController.navigate(Routes.Settings.route)
                }
            )
        }

        composable(route = Routes.DesignSystem.route) {
            DesignSystemScreen(paddingValues = paddingValues)
        }

        composable(route = Routes.StyleGenerator.route) {
            StyleGeneratorScreen(paddingValues = paddingValues)
        }

        composable(route = Routes.Settings.route) {
            SettingsScreen(paddingValues = paddingValues)
        }
    }
}
