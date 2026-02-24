package com.toure.mehedi.style_generator_ai.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toure.mehedi.style_generator_ai.ui.screens.explore.ExploreScreen
import com.toure.mehedi.style_generator_ai.ui.screens.explore.ExploreViewModel
import com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail.FashionProductDetailScreen
import com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail.FashionProductDetailViewModel
import com.toure.mehedi.style_generator_ai.ui.screens.generatedimage.GeneratedImageScreen

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
                onNavigateToProductDetail = { navController.navigate(Routes.FashionProductDetail.route) }
            )
        }
        composable(route = Routes.FashionProductDetail.route) { backStackEntry ->
            val exploreEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Explore.route)
            }
            val viewModel: ExploreViewModel = hiltViewModel(exploreEntry)
            val uiState by viewModel.uiState.collectAsState()
            FashionProductDetailScreen(
                paddingValues = paddingValues,
                product = uiState.selectedProduct,
                onNavigateToGeneratedImage = { navController.navigate(Routes.GeneratedImage.route) }
            )
        }
        composable(route = Routes.GeneratedImage.route) { backStackEntry ->
            val detailEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.FashionProductDetail.route)
            }
            val detailViewModel: FashionProductDetailViewModel = hiltViewModel(detailEntry)
            val uiState by detailViewModel.uiState.collectAsState()
            GeneratedImageScreen(
                paddingValues = paddingValues,
                generatedImageUrl = uiState.generatedImageUrl,
                productImageUrl = uiState.productImageUrl,
                userPhotoUri = uiState.userPhotoUri,
            )
        }
    }
}
