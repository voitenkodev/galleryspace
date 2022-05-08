package com.voitenko.dev.galleryspace.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.sp
import com.voitenko.dev.galleryspace.R

@ExperimentalUnitApi
@Composable
fun GallerySpaceTypography() = AppTypography(
    H1 = TextStyle(
        fontSize = 36.sp,
        fontFamily = TheSeasons,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        color = white,
    ),
    BODY1 = TextStyle(
        fontSize = 15.sp,
        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = white
    ),
    BODY2 = TextStyle(
        fontSize = 16.sp,
        fontFamily = TheSeasons,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = third,
    ),
    CAPTION = TextStyle(
        fontSize = 14.sp,
        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = fourth,
    ),
    BUTTON1 = TextStyle(
        fontSize = 18.sp,
        fontFamily = TheSeasons,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = white,
    )
)

data class AppTypography(
    val H1: TextStyle,
    val BODY1: TextStyle,
    val BODY2: TextStyle,
    val CAPTION: TextStyle,
    val BUTTON1: TextStyle,
)

private val TheSeasons = FontFamily(
    Font(R.font.the_seasons_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.the_seasons_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.the_seasons_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.the_seasons_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.the_seasons_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.the_seasons_regular, FontWeight.Normal, FontStyle.Normal)
)
private val PtSans = FontFamily(
    Font(R.font.pt_sans_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.pt_sans_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.pt_sans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.pt_sans_regular, FontWeight.Normal, FontStyle.Normal),
)