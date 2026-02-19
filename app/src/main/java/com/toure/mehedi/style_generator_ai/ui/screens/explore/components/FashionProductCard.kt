package com.toure.mehedi.style_generator_ai.ui.screens.explore.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import coil3.compose.AsyncImage
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun FashionProductCard(
    product: FashionProduct,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(product.aspectRatio)
                .clip(RoundedCornerShape(BorderRadius.large))
        )
        Text(
            text = product.name,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = Spacing.xxs)
        )
    }
}