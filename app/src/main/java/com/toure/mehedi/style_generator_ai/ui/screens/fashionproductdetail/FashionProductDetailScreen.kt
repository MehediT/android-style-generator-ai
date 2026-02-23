package com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.models.Gender
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
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(product.aspectRatio)
        )

        Column(
            modifier = Modifier.padding(Spacing.m),
            verticalArrangement = Arrangement.spacedBy(Spacing.s)
        ) {
            if (product.isPremium) {
                SuggestionChip(
                    onClick = {},
                    label = { Text(stringResource(R.string.premium)) },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = null
                        )
                    }
                )
            }

            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(Spacing.xs)
            ) {
                SuggestionChip(onClick = {}, label = { Text(product.category) })
                product.style?.let { style ->
                    SuggestionChip(onClick = {}, label = { Text(style) })
                }
                product.gender?.let { gender ->
                    SuggestionChip(onClick = {}, label = { Text(gender.name) })
                }
            }

            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (product.tags.isNotEmpty()) {
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(Spacing.xs)
                ) {
                    product.tags.forEach { tag ->
                        SuggestionChip(onClick = {}, label = { Text("#$tag") })
                    }
                }
            }
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
