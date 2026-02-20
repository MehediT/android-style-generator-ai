package com.toure.mehedi.style_generator_ai.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toure.mehedi.style_generator_ai.ui.screens.explore.ExploreScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    startDestination: String = Routes.Explore.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Routes.Explore.route) {
            ExploreScreen(
                paddingValues = paddingValues,
            )
        }
    }
}
