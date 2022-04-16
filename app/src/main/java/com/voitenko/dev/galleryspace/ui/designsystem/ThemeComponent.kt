package com.voitenko.dev.galleryspace.ui.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object GallerySpaceComponent {

    val colors: GallerySpaceColor
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}

val LocalAppColors = staticCompositionLocalOf<GallerySpaceColor> { error("No colors provided") }

val LocalAppTypography = staticCompositionLocalOf<AppTypography> { error("No font provided") }