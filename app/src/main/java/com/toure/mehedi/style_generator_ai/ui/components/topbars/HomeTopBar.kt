package com.toure.mehedi.style_generator_ai.ui.components.topbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.navigation.Routes
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    navigateToExplore: () -> Unit = {},
    navigateToRecommendations: () -> Unit = {},
    openNotificationsModal: () -> Unit = {},
    notificationCount: Int = 0,
    searchQuery: (String) -> Unit = {},
    clearSearchQuery: () -> Unit = {},
    currentDestination: String = Routes.Explore.route
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        actions = {
            SearchBadge(
                modifier = Modifier.padding(horizontal = Spacing.xxs),
                onSearchClick = {
                    // TODO : Faire une animation et géré les query ect
                }
            )
        },
        navigationIcon = {
            NotificationBadges(
                modifier = Modifier.padding(horizontal = Spacing.xxs),
                onNotificationClick = openNotificationsModal,
                notificationCount = notificationCount
            )
        },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DestinationChip(
                    modifier = Modifier
                        .height(40.dp),
                    title = stringResource(R.string.explore),
                    onChipClick = navigateToExplore,
                    selected = currentDestination == Routes.Explore.route,
                )
                DestinationChip(
                    modifier = Modifier
                        .height(40.dp),
                    title = stringResource(R.string.for_you),
                    onChipClick = navigateToRecommendations,
                    selected = currentDestination == Routes.Recommendations.route,
                )
            }

        }
    )
}

@Preview
@Composable
private fun HomeTopBarPrev() {
    AppTheme {
        HomeTopBar(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}