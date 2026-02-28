package com.toure.mehedi.style_generator_ai.ui.screens.imagedetail

import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.components.AnimatedErrorToast
import com.toure.mehedi.style_generator_ai.ui.screens.imagedetail.components.ImageDetailImage
import com.toure.mehedi.style_generator_ai.ui.screens.imagedetail.components.ImageTags
import com.toure.mehedi.style_generator_ai.ui.models.ImageUi
import com.toure.mehedi.style_generator_ai.ui.models.sampleImageUis
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun ImageDetailScreen(
    paddingValues: PaddingValues,
    product: ImageUi?,
    onNavigateToGeneratedImage: () -> Unit = {},
    viewModel: ImageDetailViewModel = hiltViewModel(),
    context: Context = LocalContext.current
) {
    if (product == null) return

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.generatedImageUrl) {
        if (uiState.generatedImageUrl != null) {
            onNavigateToGeneratedImage()
        }
    }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val bytes = context.contentResolver
                .openInputStream(uri)
                ?.readBytes() ?: byteArrayOf()

            viewModel.onImageSelected(
                bytes = bytes,
                articleUrl = product.imageUrl,
                prompt = product.negativePrompt.orEmpty(),
                userPhotoUri = uri.toString(),
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing.m)
                .padding(bottom = 88.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Spacing.s)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineMedium
            )
            ImageDetailImage(
                imageUrl = product.imageUrl,
                contentDescription = product.name,
                aspectRatio = product.aspectRatio,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(Modifier.height(Spacing.xs))
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (product.tags.isNotEmpty()) {
                ImageTags(tags = product.tags)
            }
        }

        AnimatedErrorToast(
            error = uiState.error,
            onDismiss = viewModel::clearError,
            modifier = Modifier.align(Alignment.BottomCenter),
            bottomPadding = 96.dp
        )

        if (uiState.isLoading) {
            OutlinedButton(
                onClick = viewModel::cancelGeneration,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = Spacing.l)
                    .width(240.dp)
                    .height(56.dp)
            ) {
                Text(stringResource(R.string.cancel_generation))
            }
        } else {
            Button(
                onClick = { imagePicker.launch("image/*") },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = Spacing.l)
                    .width(240.dp)
                    .height(56.dp)
            ) {
                Text(stringResource(R.string.test_on_me))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageDetailScreenPrev() {
    AppTheme {
        ImageDetailScreen(
            paddingValues = PaddingValues(),
            product = sampleImageUis.first()
        )
    }
}
