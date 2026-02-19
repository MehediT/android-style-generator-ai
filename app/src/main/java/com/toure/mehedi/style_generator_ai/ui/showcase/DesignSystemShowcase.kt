package com.toure.mehedi.style_generator_ai.ui.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toure.mehedi.style_generator_ai.ui.components.PrimaryButton
import com.toure.mehedi.style_generator_ai.ui.components.SecondaryButton
import com.toure.mehedi.style_generator_ai.ui.components.TertiaryButton
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme
import com.toure.mehedi.style_generator_ai.ui.theme.BackgroundWhite
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.CharcoalBlack
import com.toure.mehedi.style_generator_ai.ui.theme.Elevation
import com.toure.mehedi.style_generator_ai.ui.theme.Error
import com.toure.mehedi.style_generator_ai.ui.theme.Info
import com.toure.mehedi.style_generator_ai.ui.theme.LightGray
import com.toure.mehedi.style_generator_ai.ui.theme.MediumGray
import com.toure.mehedi.style_generator_ai.ui.theme.PinterestRed
import com.toure.mehedi.style_generator_ai.ui.theme.PinterestRedHover
import com.toure.mehedi.style_generator_ai.ui.theme.PureWhite
import com.toure.mehedi.style_generator_ai.ui.theme.Spacing
import com.toure.mehedi.style_generator_ai.ui.theme.Success
import com.toure.mehedi.style_generator_ai.ui.theme.Warning

@Composable
fun DesignSystemShowcase() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundWhite
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(Spacing.l)
        ) {
            // Header
            Text(
                text = "Design System",
                style = MaterialTheme.typography.displayLarge,
                color = CharcoalBlack
            )

            Spacer(modifier = Modifier.height(Spacing.xl))

            // === COULEURS ===
            SectionTitle("Couleurs")

            ColorPaletteSection(
                title = "Primaires",
                colors = listOf(
                    ColorItem("Rouge Principal", PinterestRed, "#E60023"),
                    ColorItem("Rouge Hover", PinterestRedHover, "#AD081B"),
                    ColorItem("Blanc Cassé", BackgroundWhite, "#F7F7F7"),
                    ColorItem("Noir Charbon", CharcoalBlack, "#1A1A1A")
                )
            )

            Spacer(modifier = Modifier.height(Spacing.m))

            ColorPaletteSection(
                title = "Secondaires",
                colors = listOf(
                    ColorItem("Gris Clair", LightGray, "#EFEFEF"),
                    ColorItem("Gris Moyen", MediumGray, "#767676"),
                    ColorItem("Blanc Pur", PureWhite, "#FFFFFF")
                )
            )

            Spacer(modifier = Modifier.height(Spacing.m))

            ColorPaletteSection(
                title = "Utilitaires",
                colors = listOf(
                    ColorItem("Success", Success, "#00C851"),
                    ColorItem("Warning", Warning, "#FFB300"),
                    ColorItem("Error", Error, "#FF3547"),
                    ColorItem("Info", Info, "#0099FF")
                )
            )

            Spacer(modifier = Modifier.height(Spacing.xl))

            // === TYPOGRAPHIE ===
            SectionTitle("Typographie")

            TypographySection()

            Spacer(modifier = Modifier.height(Spacing.xl))

            // === BOUTONS ===
            SectionTitle("Boutons")

            ButtonSection()

            Spacer(modifier = Modifier.height(Spacing.xl))

            // === CARTES ===
            SectionTitle("Cartes & Élévation")

            CardSection()

            Spacer(modifier = Modifier.height(Spacing.xxl))
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge,
        color = CharcoalBlack
    )
    Spacer(modifier = Modifier.height(Spacing.m))
    HorizontalDivider(color = LightGray, thickness = 2.dp)
    Spacer(modifier = Modifier.height(Spacing.m))
}

@Composable
private fun ColorPaletteSection(
    title: String,
    colors: List<ColorItem>
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall,
        color = CharcoalBlack
    )
    Spacer(modifier = Modifier.height(Spacing.s))

    colors.forEach { colorItem ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Spacing.xs),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = colorItem.color,
                        shape = RoundedCornerShape(BorderRadius.tiny)
                    )
            )
            Spacer(modifier = Modifier.width(Spacing.m))
            Column {
                Text(
                    text = colorItem.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = CharcoalBlack
                )
                Text(
                    text = colorItem.hex,
                    style = MaterialTheme.typography.bodySmall,
                    color = MediumGray
                )
            }
        }
    }
}

@Composable
private fun TypographySection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Spacing.m)
    ) {
        TypographyItem("Display", "48px / Bold", MaterialTheme.typography.displayLarge)
        TypographyItem("H1", "32px / Bold", MaterialTheme.typography.headlineLarge)
        TypographyItem("H2", "24px / SemiBold", MaterialTheme.typography.headlineMedium)
        TypographyItem("H3", "20px / Medium", MaterialTheme.typography.headlineSmall)
        TypographyItem("Body Large", "18px / Regular", MaterialTheme.typography.bodyLarge)
        TypographyItem("Body", "16px / Regular", MaterialTheme.typography.bodyMedium)
        TypographyItem("Small", "14px / Regular", MaterialTheme.typography.bodySmall)
        TypographyItem("Tiny", "12px / Medium", MaterialTheme.typography.labelSmall)
    }
}

@Composable
private fun TypographyItem(
    label: String,
    specs: String,
    textStyle: androidx.compose.ui.text.TextStyle
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MediumGray
            )
            Text(
                text = specs,
                style = MaterialTheme.typography.bodySmall,
                color = MediumGray
            )
        }
        Spacer(modifier = Modifier.height(Spacing.xxs))
        Text(
            text = "The quick brown fox jumps",
            style = textStyle,
            color = CharcoalBlack
        )
    }
}

@Composable
private fun ButtonSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Spacing.m)
    ) {
        PrimaryButton(text = "Bouton Primaire", onClick = {})
        SecondaryButton(text = "Bouton Secondaire", onClick = {})
        TertiaryButton(text = "Bouton Tertiaire", onClick = {})

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.m)
        ) {
            PrimaryButton(
                text = "Désactivé",
                onClick = {},
                enabled = false,
                modifier = Modifier.weight(1f)
            )
            SecondaryButton(
                text = "Désactivé",
                onClick = {},
                enabled = false,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun CardSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Spacing.m)
    ) {
        ElevationCard(
            title = "Elevation 1",
            description = "Cartes au repos",
            elevation = Elevation.level1
        )
        ElevationCard(
            title = "Elevation 2",
            description = "Hover cards, dropdowns",
            elevation = Elevation.level2
        )
        ElevationCard(
            title = "Elevation 3",
            description = "Modales, popovers",
            elevation = Elevation.level3
        )
        ElevationCard(
            title = "Elevation 4",
            description = "Overlays critiques",
            elevation = Elevation.level4
        )
    }
}

@Composable
private fun ElevationCard(
    title: String,
    description: String,
    elevation: androidx.compose.ui.unit.Dp
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(BorderRadius.medium),
        colors = CardDefaults.cardColors(containerColor = PureWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Column(
            modifier = Modifier.padding(Spacing.m)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = CharcoalBlack
            )
            Spacer(modifier = Modifier.height(Spacing.xxs))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MediumGray
            )
        }
    }
}

private data class ColorItem(
    val name: String,
    val color: Color,
    val hex: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DesignSystemShowcasePreview() {
    AppTheme {
        DesignSystemShowcase()
    }
}
