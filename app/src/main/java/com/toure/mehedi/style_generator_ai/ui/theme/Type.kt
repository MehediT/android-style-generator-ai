package com.toure.mehedi.style_generator_ai.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// TODO: Ajouter Inter et Poppins depuis Google Fonts
// Pour l'instant, utilisation de FontFamily.Default (similaire à Roboto)
private val InterFont = FontFamily.Default
private val PoppinsFont = FontFamily.Default

val Typography = Typography(
    // Display : 48px / Bold / Line-height 1.2 (titres hero desktop)
    displayLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 57.6.sp // 48 * 1.2
    ),

    // H1 : 32px / Bold / Line-height 1.3 (titres principaux mobile)
    headlineLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 41.6.sp // 32 * 1.3
    ),

    // H2 : 24px / SemiBold / Line-height 1.4 (sous-titres)
    headlineMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 33.6.sp // 24 * 1.4
    ),

    // H3 : 20px / Medium / Line-height 1.4 (labels sections)
    headlineSmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp // 20 * 1.4
    ),

    // Body Large : 18px / Regular / Line-height 1.6 (textes importants)
    bodyLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.8.sp // 18 * 1.6
    ),

    // Body : 16px / Regular / Line-height 1.6 (textes standards)
    bodyMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.6.sp // 16 * 1.6
    ),

    // Small : 14px / Regular / Line-height 1.5 (captions, notes)
    bodySmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp // 14 * 1.5
    ),

    // Tiny : 12px / Medium / Line-height 1.4 (labels, tags)
    labelSmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.8.sp // 12 * 1.4
    ),

    labelMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),

    labelLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)
