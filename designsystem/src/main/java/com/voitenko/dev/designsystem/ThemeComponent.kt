package com.voitenko.dev.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import com.voitenko.dev.designsystem.common.AppTypography
import com.voitenko.dev.designsystem.common.GallerySpaceColor

object GallerySpaceComponent {

    val colors: GallerySpaceColor
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}

internal val LocalAppColors = staticCompositionLocalOf<GallerySpaceColor> { error("No colors provided") }

internal val LocalAppTypography = staticCompositionLocalOf<AppTypography> { error("No font provided") }