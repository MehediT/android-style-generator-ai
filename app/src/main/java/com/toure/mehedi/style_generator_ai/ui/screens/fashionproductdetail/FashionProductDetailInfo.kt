package com.toure.mehedi.style_generator_ai.ui.screens.fashionproductdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.ui.models.Gender
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun FashionProductDetailInfo(
    name: String,
    isPremium: Boolean,
    category: String,
    style: String?,
    gender: Gender?,
    description: String,
    tags: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(Spacing.m),
        verticalArrangement = Arrangement.spacedBy(Spacing.s)
    ) {
        if (isPremium) {
            FashionProductPremiumBadge()
        }

        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium
        )

        FashionProductMetaChips(
            category = category,
            style = style,
            gender = gender
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        if (tags.isNotEmpty()) {
            FashionProductTags(tags = tags)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FashionProductDetailInfoPrev() {
    AppTheme {
        FashionProductDetailInfo(
            name = "Classic Black T-Shirt",
            isPremium = true,
            category = "CLOTHING",
            style = "Casual",
            gender = Gender.UNISEX,
            description = "Timeless black t-shirt perfect for any casual outfit",
            tags = listOf("casual", "basic", "black", "unisex")
        )
    }
}
