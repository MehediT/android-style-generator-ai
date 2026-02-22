package com.toure.mehedi.style_generator_ai.ui.components.topbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FashionProductDetailTopBar(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {},
    onShare: () -> Unit = {},
    onSave: () -> Unit = {},
    onMoreOptions: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_back)
                )
            }
        },
        actions = {
            IconButton(onClick = onShare) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = stringResource(R.string.share)
                )
            }
            IconButton(onClick = onSave) {
                Icon(
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = stringResource(R.string.save)
                )
            }
            IconButton(onClick = onMoreOptions) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.more_options)
                )
            }
        }
    )
}

@Preview
@Composable
private fun FashionProductDetailTopBarPrev() {
    AppTheme {
        FashionProductDetailTopBar()
    }
}
