package com.toure.mehedi.style_generator_ai.ui.screens.imagedetail.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme

@Composable
fun ImagePremiumBadge(
    modifier: Modifier = Modifier,
) {
    SuggestionChip(
        modifier = modifier,
        onClick = {},
        label = { Text(stringResource(R.string.premium)) },
        icon = {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ImagePremiumBadgePrev() {
    AppTheme {
        ImagePremiumBadge()
    }
}
