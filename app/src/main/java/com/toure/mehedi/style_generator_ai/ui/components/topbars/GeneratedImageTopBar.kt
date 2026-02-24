package com.toure.mehedi.style_generator_ai.ui.components.topbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneratedImageTopBar(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(stringResource(R.string.result)) },
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_back)
                )
            }
        }
    )
}

@Preview
@Composable
private fun GeneratedImageTopBarPrev() {
    AppTheme {
        GeneratedImageTopBar()
    }
}
