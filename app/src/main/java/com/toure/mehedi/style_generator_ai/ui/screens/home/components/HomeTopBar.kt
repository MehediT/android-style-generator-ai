package com.toure.mehedi.style_generator_ai.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(
        title = {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "For you, name", // TODO: Replace "name" with actual user name
                )
                Box(
                    modifier = Modifier
                        .defaultMinSize(120.dp)
                        .height(3.dp)
                        .background(MaterialTheme.colorScheme.onPrimaryContainer)
                )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Navigate to recommendations */ }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Recommendations"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}
