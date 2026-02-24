package com.toure.mehedi.style_generator_ai.ui.screens.explore.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toure.mehedi.style_generator_ai.ui.models.ExploreCard
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing

data class PromotionCard(
    override val id: String,
    override val title: String,
    override val description: String,
    val action: PromotionAction
) : ExploreCard

sealed class PromotionAction {
    object Premium : PromotionAction()
    class Style(val style: String) : PromotionAction()
}

@Composable
fun PromotionCardComposable(
    modifier: Modifier = Modifier,
    promotionCard: PromotionCard,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        onClick = onClick
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .padding(Spacing.s)
                    .align(Alignment.BottomStart),
                text = promotionCard.title,
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                fontWeight = FontWeight.Bold
            )
            Icon(
                modifier = Modifier
                    .padding(Spacing.s)
                    .align(Alignment.TopEnd),
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PromotionCardPreview() {
    PromotionCardComposable(
        promotionCard = PromotionCard(
            id = "1",
            title = "Premium",
            description = "Get Premium access",
            action = PromotionAction.Premium
        )
    )
}
