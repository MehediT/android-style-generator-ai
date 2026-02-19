package com.toure.mehedi.style_generator_ai.ui.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.toure.mehedi.style_generator_ai.ui.screens.explore.components.FashionProductCard
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: ExploreViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentPadding = PaddingValues(horizontal = Spacing.m, vertical = Spacing.s),
        horizontalArrangement = Arrangement.spacedBy(Spacing.s),
        verticalItemSpacing = Spacing.s
    ) {
        items(uiState.products, key = { it.id }) { product ->
            FashionProductCard(product = product)
        }
    }
}


@Preview
@Composable
private fun ExploreScreenPrev() {
    ExploreScreen(
        paddingValues = PaddingValues()
    )
}