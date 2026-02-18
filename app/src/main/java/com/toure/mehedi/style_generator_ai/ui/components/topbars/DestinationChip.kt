package com.toure.mehedi.style_generator_ai.ui.components.topbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toure.mehedi.style_generator_ai.ui.theme.BackgroundWhite
import com.toure.mehedi.style_generator_ai.ui.theme.CharcoalBlack

@Composable
fun DestinationChip(
    modifier: Modifier = Modifier,
    onChipClick: () -> Unit = {},
    selected: Boolean = true,
    title: String,
) {
    val contentColor = if (selected) CharcoalBlack else BackgroundWhite
    val containerColor = if (selected) BackgroundWhite else Color.Transparent
    Button(
        onClick = onChipClick,
        enabled = !selected,
        modifier = modifier,
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
        )
    }

}

@Preview
@Composable
private fun DestinationChipPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DestinationChip(
                modifier = Modifier,
                title = "Explore",
                selected = true,
            )

            DestinationChip(
                modifier = Modifier,
                title = "For you",
                selected = false,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DestinationChip(
                modifier = Modifier,
                title = "Explore",
                selected = false,
            )

            DestinationChip(
                modifier = Modifier,
                title = "For you",
                selected = true,
            )
        }
    }
}