package com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.models.FashionProduct
import com.toure.mehedi.style_generator_ai.ui.models.sampleFashionProducts
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun FashionProductDetailScreen(
    paddingValues: PaddingValues,
    product: FashionProduct?,
    viewModel: FashionProductDetailViewModel = hiltViewModel()
) {
    if (product == null) return

    val uiState by viewModel.uiState.collectAsState()
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let { viewModel.onImageSelected(it) }
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
            FashionProductDetailImage(
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
                FashionProductTags(tags = product.tags)
            }
        }

        Button(
            onClick = { imagePicker.launch("image/*") },
            enabled = !uiState.isLoading,
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
