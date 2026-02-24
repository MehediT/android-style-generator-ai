package com.toure.mehedi.style_generator_ai.ui.screens.generatedimage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun UploadedImagesRow(
    uploadedPhoto: String,
    modifier: Modifier = Modifier,
    relatedImages: List<String> = emptyList(),
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Spacing.xs, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            AsyncImage(
                model = uploadedPhoto,
                contentDescription = stringResource(R.string.your_photo),
                modifier = Modifier
                    .size(36.dp)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.primary,
                        RoundedCornerShape(BorderRadius.small)
                    )
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(BorderRadius.small)),
                contentScale = ContentScale.Crop,
            )
        }
        items(relatedImages) {
            AsyncImage(
                model = it,
                contentDescription = stringResource(R.string.product_image),
                modifier = Modifier
                    .size(36.dp)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(BorderRadius.small)),
                contentScale = ContentScale.Crop,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun UploadedImagesRowPreview() {
    UploadedImagesRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        uploadedPhoto = "https://picsum.photos/seed/picsum/400/400",
        relatedImages = listOf(
            "https://picsum.photos/id/237/200/200",
            "https://picsum.photos/id/238/200/200",
            "https://picsum.photos/id/239/200/300",
            "https://picsum.photos/id/240/200/200",
        )
    )
}