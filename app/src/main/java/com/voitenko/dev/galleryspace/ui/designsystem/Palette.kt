package com.voitenko.dev.galleryspace.ui.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun GallerySpaceLightPalette() = GallerySpaceColor(
    background = crystal,
    control = darkPurple,
    primary = darkPurple,
    primaryText = darkPurple,
    secondary = Color.White,
    secondaryText = Color.Black,
    errorColor = darkRed,
    successColor = cyan2,
    warningColor = darkYellow,
    buttonText = Color.White,
    button = darkPurple,
    hint = Color.Black.copy(alpha = 0.3F)
)

@Composable
fun GallerySpaceDarkPalette() = GallerySpaceLightPalette()

data class GallerySpaceColor(
    val background: Color,
    val control: Color,
    val primary: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val secondary: Color,
    val buttonText: Color,
    val button: Color,
    val successColor: Color,
    val warningColor: Color,
    val errorColor: Color,
    val hint: Color,
)

val white = Color(0xFFFFFFFF)
val gray = Color(236, 234, 235)
val gray2 = Color(0xFFEEEEEE)
val gray3 = Color(0xFF888888)

val lightPurple = Color(0xFF5622E5)
val darkPurple = Color(0xFF4119AF)

val darkYellow = Color(0xFFD5BD3F)
val lightYellow = Color(0xFFFADE4B)

val lightRed = Color(0xFFEA3469)
val darkRed = Color(0xFFC52B58)

val cyan1shadow1 = Color(0xFF81E4C6)
val cyan1 = Color(0xFF28D8A3)
val cyan2 = Color(0xFF00BEB2)
val cyan2shadow2 = Color(0xFF06948B)

val crystal = Color(0xFFD0DBE5)