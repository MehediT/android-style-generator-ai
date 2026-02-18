package com.toure.mehedi.style_generator_ai.ui.components.topbars

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toure.mehedi.style_generator_ai.ui.theme.BackgroundWhite

@Composable
fun SearchBadge(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {}
) {
    FilledIconButton(
        onClick = onSearchClick,
        modifier = modifier.size(40.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.Black.copy(alpha = 0.6f),
            contentColor = BackgroundWhite
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search",
        )
    }
}

@Preview
@Composable
private fun SearchBadgePreview() {
    SearchBadge()
}