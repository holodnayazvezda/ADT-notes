package com.example.adt_notes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = WhiteBackgroundPrimary,
    onBackground = WhiteTextPrimary,
    primary = AccentBlue,
    onPrimary = WhiteBackgroundPrimary,
    secondary = WhiteBackgroundSecondary,
    onSecondary = WhiteTextSecondary
)

private val LightColorScheme = lightColorScheme(
    background = DarkBackgroundPrimary,
    onBackground = DarkTextPrimary,
    primary = AccentBlue,
    onPrimary = DarkBackgroundPrimary,
    secondary = DarkBackgroundSecondary,
    onSecondary = DarkTextSecondary
)

@Composable
fun ADTnotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}