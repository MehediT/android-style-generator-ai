package com.toure.mehedi.style_generator_ai.ui.screens.generatedimage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun GeneratedImageScreen(
    paddingValues: PaddingValues,
    generatedImageUrl: String?,
    productImageUrl: String?,
    userPhotoUri: String?,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(Spacing.m),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (generatedImageUrl != null) {
            AsyncImage(
                model = generatedImageUrl,
                contentDescription = stringResource(R.string.generated_image),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .weight(1f)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(BorderRadius.small)),
                contentScale = ContentScale.Fit,
            )
        } else {
            Spacer(Modifier.weight(1f))
        }
        if (productImageUrl != null && userPhotoUri != null) {
            Spacer(Modifier.height(Spacing.xxs))
            UploadedImagesRow(
                modifier = Modifier.fillMaxWidth(),
                uploadedPhoto = userPhotoUri,
                relatedImages = listOf(productImageUrl)
            )
        }
        Spacer(Modifier.height(Spacing.m))
        Button(
            onClick = {},
            modifier = Modifier
                .width(240.dp)
                .height(56.dp)
        ) {
            Text(stringResource(R.string.adjust))
        }
        Spacer(Modifier.height(Spacing.l))
    }
}


@Preview(showBackground = true)
@Composable
private fun GeneratedImageScreenPrev() {
    AppTheme {
        GeneratedImageScreen(
            paddingValues = PaddingValues(),
            generatedImageUrl = "https://picsum.photos/seed/picsum/400/400",
            productImageUrl = "https://picsum.photos/seed/picsum/400/400",
            userPhotoUri = "https://picsum.photos/seed/picsum/400/400",
        )
    }
}
