package br.com.jxr.cstv.ui.theme // ktlint-disable filename

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = LightPurple,
    primaryVariant = DarkPurple,
    secondary = Red,
    onSecondary = Color.White,
    background = DarkPurple,
    onBackground = Color.White,
    surface = DarkPurple
)

private val LightColorPalette = lightColors(
    primary = LightPurple,
    primaryVariant = DarkPurple,
    secondary = Red,
    onSecondary = Color.White,
    background = DarkPurple,
    onBackground = Color.White,
    surface = DarkPurple

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CstvTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
