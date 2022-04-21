package com.voitenko.dev.galleryspace.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.ExperimentalUnitApi

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