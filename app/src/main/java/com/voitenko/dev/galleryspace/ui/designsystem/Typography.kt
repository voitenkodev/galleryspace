package com.voitenko.dev.galleryspace.ui.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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
        fontSize = 34.sp,
        fontFamily = TheSeasons,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        color = Color.Black,
    ), H2 = TextStyle(
        fontSize = 28.sp,
        fontFamily = TheSeasons,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        color = Color.Black
    ), H3 = TextStyle(
        fontSize = 24.sp,
        fontFamily = TheSeasons,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        color = Color.Black
    ), BODY1 = TextStyle(
        fontSize = 24.sp,
        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = Color.Black
    ), BODY2 = TextStyle(
        fontSize = 18.sp,
        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = Color.Black
    ), BODY3 = TextStyle(
        fontSize = 14.sp,
        fontFamily = TheSeasons,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        color = Color.Black,
        textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline))
    ), TextStyle(
        fontSize = 18.sp,
        fontFamily = PtSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        color = Color.Black
    ), BUTTON2 = TextStyle(
        fontSize = 18.sp,
        fontFamily = PtSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        color = Color.Black
    )
)

data class AppTypography(
    val H1: TextStyle,
    val H2: TextStyle,
    val H3: TextStyle,
    val BODY1: TextStyle,
    val BODY2: TextStyle,
    val BODY3: TextStyle,
    val BUTTON1: TextStyle,
    val BUTTON2: TextStyle,
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