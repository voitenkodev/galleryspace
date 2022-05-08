package com.voitenko.dev.designsystem.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.voitenko.dev.designsystem.LocalAppColors
import com.voitenko.dev.designsystem.LocalAppTypography

@ExperimentalUnitApi
@Composable
fun GallerySpaceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = when (darkTheme) {
        true -> GallerySpaceDarkPalette()
        false -> GallerySpaceLightPalette()
    }

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides GallerySpaceTypography(),
        content = content
    )
}