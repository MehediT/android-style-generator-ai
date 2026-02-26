package com.toure.mehedi.style_generator_ai.ui.screens.imagedetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@Composable
fun ImageTags(
    tags: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Spacing.xs)
    ) {
        items(tags) { tag ->
            SuggestionChip(
                onClick = {},
                label = {
                    Text(
                        text = "#$tag",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageTagsPrev() {
    AppTheme {
        ImageTags(
            tags = listOf("casual", "basic", "black", "unisex")
        )
    }
}
