package com.toure.mehedi.style_generator_ai.ui.screens.imagedetail.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.ui.models.Gender
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun ImageMetaChips(
    category: String,
    style: String?,
    gender: Gender?,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(Spacing.xs)
    ) {
        SuggestionChip(onClick = {}, label = { Text(category) })
        style?.let {
            SuggestionChip(onClick = {}, label = { Text(it) })
        }
        gender?.let {
            SuggestionChip(onClick = {}, label = { Text(it.name) })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageMetaChipsPrev() {
    AppTheme {
        ImageMetaChips(
            category = "CLOTHING",
            style = "Casual",
            gender = Gender.UNISEX
        )
    }
}
