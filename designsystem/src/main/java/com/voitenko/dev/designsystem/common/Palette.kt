package com.voitenko.dev.designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun GallerySpaceLightPalette() = GallerySpaceColor(
    primary = white,
    secondary = lightYellow,
    tertiary = greengray,

    primaryControl = black,
    secondaryControl = brown,

    shadow = dark,
)

@Composable
fun GallerySpaceDarkPalette() = GallerySpaceColor(
    primary = black,
    secondary = white,
    tertiary = greengray,

    primaryControl = white,
    secondaryControl = brown,

    shadow = dark,
)

data class GallerySpaceColor(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,

    val primaryControl: Color,
    val secondaryControl: Color,

    val shadow: Color,
)

internal val white = Color(0xFFF1F1F1)
internal val black = Color(0xFF181A17)
internal val brown = Color(0xFFB0815A)
internal val dark = Color(0xFF242424)
internal val greengray = Color(0xFF201F19)

internal val secondary = Color(0xFF151515)
internal val fourth = Color(0xFF707070)
internal val sixteen = Color(0xFF228D57)


internal val crystal = Color(0xFFD0DBE5)
internal val crystalDark = Color(0xFFB3C1CE)

internal val gray1 = Color(0xFFEEEEEE)
internal val gray2 = Color(0xFFD5D5D5)
internal val gray3 = Color(0xFF525252)

internal val lightPurple = Color(0xFF5622E5)
internal val darkPurple = Color(0xFF4119AF)

internal val darkYellow = Color(0xFFB6A238)
internal val lightYellow = Color(0xFFD5BD3F)

internal val lightRed = Color(0xFFEA3469)
internal val darkRed = Color(0xFFC52B58)

internal val cyan1shadow1 = Color(0xFF81E4C6)
internal val cyan1 = Color(0xFF28D8A3)
internal val cyan2 = Color(0xFF00BEB2)
internal val cyan2shadow2 = Color(0xFF06948B)