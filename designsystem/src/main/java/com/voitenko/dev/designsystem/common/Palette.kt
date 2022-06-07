package com.voitenko.dev.designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun GallerySpaceLightPalette() = GallerySpaceColor(
    primary = white,
    primaryInverse = almostBlack,
    secondary = almostWhite,
    shadow = darkGray,
    caption = lightGray,
    priceUp = green,
    priceDown = red
)

@Composable
fun GallerySpaceDarkPalette() = GallerySpaceColor(
    primary = almostBlack,
    primaryInverse = almostWhite,
    secondary = black,
    shadow = darkGray,
    caption = lightGray,
    priceUp = green,
    priceDown = red
)

data class GallerySpaceColor(
    val primary: Color, // black - white
    val primaryInverse: Color, // black - white
    val secondary: Color, //white - black
    val shadow: Color, // darkgray - darkgray
    val caption: Color,// lightgray - lightgray
    val priceUp: Color,
    val priceDown: Color,
)


internal val black = Color(0xff000000)
internal val white = Color(0xffffffff)

internal val almostWhite = Color(0xFFF1F1F1)
internal val almostBlack = Color(0xFF121311)

internal val darkGray = Color(0xFF1F1F1F)
internal val lightGray = Color(0xFF585858)

internal val yellow = Color(0xFFECBE6E)
internal val green = Color(0xFF228D57)
internal val red = Color(0xFFEA3469)


//

//internal val brown = Color(0xFFB0815A)
//internal val dark = Color(0xFF161515)
//internal val greengray = Color(0xFF111111)
//internal val sixteen = Color(0xFF228D57)
//internal val yellow = Color(0xFFECBE6E)
//
//internal val secondary = Color(0xFF151515)
//internal val fourth = Color(0xFF707070)
//
//
//internal val crystal = Color(0xFFD0DBE5)
//internal val crystalDark = Color(0xFFB3C1CE)
//
//internal val gray1 = Color(0xFFEEEEEE)
//internal val gray2 = Color(0xFFD5D5D5)
//internal val gray3 = Color(0xFF525252)
//
//internal val lightPurple = Color(0xFF5622E5)
//internal val darkPurple = Color(0xFF4119AF)
//
//internal val darkYellow = Color(0xFFB6A238)
//internal val lightYellow = Color(0xFFD5BD3F)
//
//internal val lightRed = Color(0xFFEA3469)
//internal val darkRed = Color(0xFFC52B58)
//
//internal val cyan1shadow1 = Color(0xFF81E4C6)
//internal val cyan1 = Color(0xFF28D8A3)
//internal val cyan2 = Color(0xFF00BEB2)
//internal val cyan2shadow2 = Color(0xFF06948B)