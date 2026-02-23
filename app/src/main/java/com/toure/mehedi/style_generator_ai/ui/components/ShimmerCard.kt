package com.toure.mehedi.style_generator_ai.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Composable shimmer placeholder — remplace accompanist-placeholder supprimé.
 *
 * @param modifier  Modifier appliqué au composant (taille, forme, etc.)
 * @param baseColor Couleur de base du placeholder
 * @param highlight Couleur du reflet animé
 */
@Composable
fun ShimmerPlaceholder(
    modifier: Modifier = Modifier,
    baseColor: Color = Color(0xFFE0E0E0),
    highlight: Color = Color(0xFFF5F5F5),
) {
    BoxWithConstraints(modifier = modifier) {
        val widthPx = with(LocalDensity.current) { maxWidth.toPx() }

        val transition = rememberInfiniteTransition(label = "shimmer")
        val offset by transition.animateFloat(
            initialValue = -widthPx,
            targetValue = widthPx * 2,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1200, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "shimmer_offset"
        )

        val brush = Brush.linearGradient(
            colors = listOf(baseColor, highlight, baseColor),
            start = Offset(offset, 0f),
            end = Offset(offset + widthPx, 0f)
        )

        Box(Modifier.fillMaxSize().background(brush))
    }
}

// ─── Previews ────────────────────────────────────────────────────────────────

@Preview(name = "Ligne texte", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShimmerLinePreview() {
    ShimmerPlaceholder(
        modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
            .padding(horizontal = 16.dp)
    )
}

@Preview(name = "Card skeleton", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShimmerCardPreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .width(300.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ShimmerPlaceholder(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        ShimmerPlaceholder(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(20.dp)
        )
        ShimmerPlaceholder(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(14.dp)
        )
    }
}