package com.toure.mehedi.style_generator_ai.ui.components.topbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toure.mehedi.style_generator_ai.ui.theme.BackgroundWhite
import com.toure.mehedi.style_generator_ai.ui.theme.PinterestRed

@Composable
fun NotificationBadges(
    modifier: Modifier = Modifier,
    notificationCount: Int = 0,
    onNotificationClick: () -> Unit = {}
) {
    FilledIconButton(
        onClick = onNotificationClick,
        modifier = modifier.size(40.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.Black.copy(alpha = 0.6f),
            contentColor = BackgroundWhite
        )
    ) {
        BadgedBox(
            badge = {
                if (notificationCount > 0) {
                    Badge(
                        containerColor = PinterestRed,
                        contentColor = BackgroundWhite
                    )
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                tint = BackgroundWhite
            )
        }
    }
}

@Preview
@Composable
private fun NotificationBadgesPreview() {
    Row(
        modifier = Modifier.size(
            width = 96.dp,
            height = 40.dp
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        NotificationBadges(
            modifier = Modifier
        )
        NotificationBadges(
            modifier = Modifier,
            notificationCount = 3
        )
    }
}