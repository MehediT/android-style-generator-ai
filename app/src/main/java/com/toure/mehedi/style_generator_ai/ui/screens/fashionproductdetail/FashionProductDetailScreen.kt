package com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.s)
    ) {
        Text(
            text = product.name,
            style = MaterialTheme.typography.headlineMedium
        )
        FashionProductDetailImage(
            imageUrl = product.imageUrl,
            contentDescription = product.name,
            aspectRatio = product.aspectRatio,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )
        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        if (product.tags.isNotEmpty()) {
            FashionProductTags(tags = product.tags)
        }
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
