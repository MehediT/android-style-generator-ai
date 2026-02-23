package com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.models.sampleFashionProducts
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun FashionProductDetailScreen(
    paddingValues: PaddingValues,
    product: FashionProduct?,
) {
    if (product == null) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(Spacing.m)
            .verticalScroll(rememberScrollState())
    ) {
        FashionProductDetailImage(
            imageUrl = product.imageUrl,
            contentDescription = product.name,
            aspectRatio = product.aspectRatio
        )
        FashionProductDetailInfo(
            name = product.name,
            isPremium = product.isPremium,
            category = product.category,
            style = product.style,
            gender = product.gender,
            description = product.description,
            tags = product.tags
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FashionProductDetailScreenPrev() {
    AppTheme {
        FashionProductDetailScreen(
            paddingValues = PaddingValues(),
            product = sampleFashionProducts.first()
        )
    }
}
