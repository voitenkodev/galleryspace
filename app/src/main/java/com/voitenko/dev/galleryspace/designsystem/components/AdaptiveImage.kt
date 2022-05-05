package com.voitenko.dev.galleryspace.designsystem.components

import android.graphics.drawable.Drawable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.voitenko.dev.galleryspace.designsystem.modifiers.rolling

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun BoxWithConstraintsScope.AdaptiveImage(
    modifier: Modifier = Modifier,
    drawable: Drawable, paddingCoefficient: Double = 1.5
) {
    val imageHeight = drawable.intrinsicHeight.toFloat()
    val imageWidth = drawable.intrinsicWidth.toFloat()
    val height = if (imageHeight > imageWidth) maxHeight.value / paddingCoefficient
    else maxHeight.value / (imageWidth / imageHeight) / paddingCoefficient
    val width = if (imageHeight < imageWidth) maxWidth.value / paddingCoefficient
    else maxWidth.value / (imageHeight / imageWidth) / paddingCoefficient

    Image(
        bitmap = drawable.toBitmap().asImageBitmap(),
        modifier = modifier.size(width = width.dp, height = height.dp),
        contentDescription = ""
    )
}