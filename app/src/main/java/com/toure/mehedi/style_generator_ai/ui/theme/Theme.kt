package com.toure.mehedi.style_generator_ai.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PinterestRed,
    onPrimary = PureWhite,
    primaryContainer = PinterestRedHover,
    onPrimaryContainer = PureWhite,

    secondary = MediumGray,
    onSecondary = PureWhite,

    tertiary = Info,
    onTertiary = PureWhite,

    background = CharcoalBlack,
    onBackground = BackgroundWhite,

    surface = CharcoalBlack,
    onSurface = BackgroundWhite,

    surfaceVariant = LightGray,
    onSurfaceVariant = CharcoalBlack,

    error = Error,
    onError = PureWhite,

    outline = LightGray,
    outlineVariant = MediumGray
)

private val LightColorScheme = lightColorScheme(
    primary = PinterestRed,
    onPrimary = PureWhite,
    primaryContainer = PinterestRedHover,
    onPrimaryContainer = PureWhite,

    secondary = MediumGray,
    onSecondary = PureWhite,

    tertiary = Info,
    onTertiary = PureWhite,

    background = BackgroundWhite,
    onBackground = CharcoalBlack,

    surface = PureWhite,
    onSurface = CharcoalBlack,

    surfaceVariant = LightGray,
    onSurfaceVariant = CharcoalBlack,

    error = Error,
    onError = PureWhite,

    outline = LightGray,
    outlineVariant = MediumGray
)

@Composable
fun AndroidstylegeneratoraiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color désactivé par défaut pour respecter le design Pinterest
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
