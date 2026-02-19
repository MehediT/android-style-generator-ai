package com.toure.mehedi.style_generator_ai.ui.screens.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.toure.mehedi.style_generator_ai.ui.models.FashionCategory
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.models.Gender
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun FashionProductCard(
    product: FashionProduct,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(product.aspectRatio)
                .clip(RoundedCornerShape(BorderRadius.large))
        )
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(BorderRadius.small)
                )
                .padding(Spacing.xxs),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

    }
}

@Preview
@Composable
private fun FashionProductCardPrev() {
    FashionProductCard(
        FashionProduct(
            id = "product_1",
            name = "Classic Black T-Shirt",
            description = "Timeless black t-shirt perfect for any casual outfit",
            category = FashionCategory.CLOTHING,
            imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe1.jpg",
            aspectRatio = 1f,
            tags = listOf("casual", "basic", "black", "unisex"),
            gender = Gender.UNISEX,
            style = "Casual",
            color = "Black"
        )
    )
}