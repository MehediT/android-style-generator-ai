package com.toure.mehedi.style_generator_ai.ui.screens.explore

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.toure.mehedi.style_generator_ai.ui.components.ErrorToast
import com.toure.mehedi.style_generator_ai.ui.models.ExploreCard
import com.toure.mehedi.style_generator_ai.ui.models.ImageUi
import com.toure.mehedi.style_generator_ai.ui.screens.explore.components.ImageCard
import com.toure.mehedi.style_generator_ai.ui.screens.explore.components.PromotionAction
import com.toure.mehedi.style_generator_ai.ui.screens.explore.components.PromotionCard
import com.toure.mehedi.style_generator_ai.ui.screens.explore.components.PromotionCardComposable
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun ExploreScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    onNavigateToProductDetail: () -> Unit = {},
    viewModel: ExploreViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        ExploreContent(
            modifier = Modifier.fillMaxSize(),
            uiState = uiState,
            onNavigateToProductDetail = { product ->
                viewModel.selectProduct(product)
                onNavigateToProductDetail()
            }
        )

        AnimatedVisibility(
            visible = uiState.error != null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = Spacing.m),
            enter = slideInVertically { it } + fadeIn(),
            exit = slideOutVertically { it } + fadeOut()
        ) {
            uiState.error?.let {
                ErrorToast(message = it, onDismiss = viewModel::clearError)
            }
        }
    }
}

@Composable
private fun ExploreContent(
    modifier: Modifier,
    uiState: ExploreUiState,
    onNavigateToProductDetail: (ImageUi) -> Unit = {},
) {
    // Crée une liste qui alterne produits et promotions
    val itemsWithPromotions: List<ExploreCard> = buildList {
        var productCount = 0
        uiState.products.forEach { product ->
            add(product)
            productCount++
            // Ajoute une promotion après le 2ème, 5ème, 8ème produit, etc.
            if (productCount % 3 == 2) {
                add(
                    PromotionCard(
                        id = "premium_$productCount",
                        title = "Premium",
                        description = "Get Premium access",
                        action = PromotionAction.Premium
                    )
                )
            }
        }
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = Spacing.m, vertical = Spacing.s),
        horizontalArrangement = Arrangement.spacedBy(Spacing.s),
        verticalItemSpacing = Spacing.s
    ) {
        items(itemsWithPromotions.size) { index ->
            when (val item = itemsWithPromotions[index]) {
                is PromotionCard -> {
                    PromotionCardComposable(
                        promotionCard = item,
                        onClick = { /* Handle promotion click */ }
                    )
                }
                is ImageUi -> {
                    ImageCard(
                        product = item,
                        onClick = { onNavigateToProductDetail(item) }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun ExploreContentPrev() {
    ExploreContent(
        modifier = Modifier.fillMaxSize(),
        uiState = ExploreUiState()
    )
}