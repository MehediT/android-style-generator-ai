package com.toure.mehedi.style_generator_ai.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// ===== Shadows (élévation) =====
object Elevation {
    // Elevation 1 : 0 1px 3px rgba(0,0,0,0.08) (cartes au repos)
    val level1 = 1.dp
    val level1Color = Color(0x14000000) // rgba(0,0,0,0.08)

    // Elevation 2 : 0 2px 8px rgba(0,0,0,0.12) (hover cards, dropdowns)
    val level2 = 2.dp
    val level2Color = Color(0x1F000000) // rgba(0,0,0,0.12)

    // Elevation 3 : 0 4px 16px rgba(0,0,0,0.16) (modales, popovers)
    val level3 = 4.dp
    val level3Color = Color(0x29000000) // rgba(0,0,0,0.16)

    // Elevation 4 : 0 8px 32px rgba(0,0,0,0.24) (overlays critiques)
    val level4 = 8.dp
    val level4Color = Color(0x3D000000) // rgba(0,0,0,0.24)
}
