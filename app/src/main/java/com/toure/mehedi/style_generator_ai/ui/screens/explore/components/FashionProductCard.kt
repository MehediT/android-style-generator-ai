package com.toure.mehedi.style_generator_ai.ui.screens.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.toure.mehedi.style_generator_ai.ui.components.ShimmerPlaceholder
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.models.Gender
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun FashionProductCard(
    product: FashionProduct,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {
    var isLoading by remember { mutableStateOf(true) }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(BorderRadius.large),
        onClick = { onClick(product.id) }
    ) {
        Box {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(product.aspectRatio),
                onLoading = { isLoading = true },
                onSuccess = { isLoading = false },
                onError = { isLoading = false }
            )
            if (isLoading) {
                ShimmerPlaceholder(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(product.aspectRatio)
                )
            }
            FashionProductTitle(
                title = product.name,
                modifier = modifier
                    .padding(Spacing.xxs)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}


@Composable
fun FashionProductTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(
                    topStart = BorderRadius.small,
                    bottomStart = BorderRadius.small,
                    bottomEnd = BorderRadius.large,
                    topEnd = BorderRadius.small,
                )
            )
            .padding(
                vertical = Spacing.xxs,
                horizontal = Spacing.xs
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
private fun FashionProductCardPrev() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            FashionProductCard(
                FashionProduct(
                    id = "product_1",
                    name = "Classic Black T-Shirt",
                    description = "Timeless black t-shirt perfect for any casual outfit",
                    category = "CLOTHING",
                    imageUrl = "https://picsum.photos/seed/picsum/200/300",
                    aspectRatio = 2/3f,
                    tags = listOf("casual", "basic", "black", "unisex"),
                    gender = Gender.UNISEX,
                    style = "Casual",
                )
            )
        }
    }
}