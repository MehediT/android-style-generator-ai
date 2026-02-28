package com.toure.mehedi.style_generator_ai.ui.screens.imagedetail.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius

@Composable
fun ImageDetailImage(
    imageUrl: String,
    contentDescription: String,
    aspectRatio: Float,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(aspectRatio)
            .clip(RoundedCornerShape(BorderRadius.xLarge))
    )
}

@Preview(showBackground = true)
@Composable
private fun ImageDetailImagePrev() {
    AppTheme {
        ImageDetailImage(
            imageUrl = "https://picsum.photos/seed/picsum/400/400",
            contentDescription = "Classic Black T-Shirt",
            aspectRatio = 1f
        )
    }
}