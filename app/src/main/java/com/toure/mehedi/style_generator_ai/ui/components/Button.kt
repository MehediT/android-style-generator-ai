package com.toure.mehedi.style_generator_ai.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toure.mehedi.style_generator_ai.ui.theme.BackgroundWhite
import com.toure.mehedi.style_generator_ai.ui.theme.BorderRadius
import com.toure.mehedi.style_generator_ai.ui.theme.CharcoalBlack
import com.toure.mehedi.style_generator_ai.ui.theme.PinterestRed
import com.toure.mehedi.style_generator_ai.ui.theme.PinterestRedHover
import com.toure.mehedi.style_generator_ai.ui.theme.PureWhite

/**
 * Bouton Primaire (Rouge Pinterest)
 * - Background : #E60023
 * - Text : #FFFFFF
 * - Hover : #AD081B + Elevation 2
 * - Padding : 12px 24px
 * - Border-radius : 8px
 * - Font : 16px Medium
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Button(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 48.dp),
        enabled = enabled,
        interactionSource = interactionSource,
        shape = RoundedCornerShape(BorderRadius.medium),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isHovered) PinterestRedHover else PinterestRed,
            contentColor = PureWhite,
            disabledContainerColor = PinterestRed.copy(alpha = 0.5f),
            disabledContentColor = PureWhite.copy(alpha = 0.5f)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 2.dp,
            hoveredElevation = 2.dp
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

/**
 * Bouton Secondaire (Outline)
 * - Border : 2px solid #E60023
 * - Text : #E60023
 * - Hover : Background #E60023 + Text #FFFFFF
 * - Padding : 12px 24px
 * - Border-radius : 8px
 */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    OutlinedButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 48.dp),
        enabled = enabled,
        interactionSource = interactionSource,
        shape = RoundedCornerShape(BorderRadius.medium),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (isHovered) PinterestRed else Color.Transparent,
            contentColor = if (isHovered) PureWhite else PinterestRed,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = PinterestRed.copy(alpha = 0.5f)
        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (enabled) PinterestRed else PinterestRed.copy(alpha = 0.5f)
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

/**
 * Bouton Tertiaire (Ghost)
 * - Background : transparent
 * - Text : #1A1A1A
 * - Hover : Background #F7F7F7
 * - Padding : 12px 24px
 */
@Composable
fun TertiaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    TextButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 48.dp),
        enabled = enabled,
        interactionSource = interactionSource,
        shape = RoundedCornerShape(BorderRadius.medium),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (isHovered) BackgroundWhite else Color.Transparent,
            contentColor = CharcoalBlack,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = CharcoalBlack.copy(alpha = 0.5f)
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
