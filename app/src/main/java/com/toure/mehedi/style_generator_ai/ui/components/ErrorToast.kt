package com.toure.mehedi.style_generator_ai.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.ui.models.toErrorResId
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.CharcoalBlack
import com.toure.mehedi.style_generator_ai.ui.theme.DarkOnSurfaceVariant
import com.toure.mehedi.style_generator_ai.ui.theme.Error
import com.toure.mehedi.style_generator_ai.ui.theme.PureWhite
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing
import kotlinx.coroutines.delay

@Composable
fun ErrorToast(
    message: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(message) {
        delay(3_000)
        onDismiss()
    }

    Surface(
        shape = RoundedCornerShape(BorderRadius.large),
        color = CharcoalBlack,
        shadowElevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.m)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.m, vertical = Spacing.s),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.s)
        ) {
            Icon(
                imageVector = Icons.Rounded.ErrorOutline,
                contentDescription = null,
                tint = Error,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = message,
                color = PureWhite,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = onDismiss,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Top)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = stringResource(R.string.dismiss),
                    tint = DarkOnSurfaceVariant,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun AnimatedErrorToast(
    error: Throwable?,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    bottomPadding: Dp = Spacing.m
) {
    val message = error?.let { stringResource(it.toErrorResId()) }

    AnimatedVisibility(
        visible = error != null,
        modifier = modifier.padding(bottom = bottomPadding),
        enter = slideInVertically { it } + fadeIn(),
        exit = slideOutVertically { it } + fadeOut()
    ) {
        message?.let {
            ErrorToast(message = it, onDismiss = onDismiss)
        }
    }
}

@Preview
@Composable
private fun ErrorToastPreview() {
    ErrorToast(
        message = "Network error — please check your connection",
        onDismiss = {}
    )
}
