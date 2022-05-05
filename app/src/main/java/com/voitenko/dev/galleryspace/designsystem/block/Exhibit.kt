package com.voitenko.dev.galleryspace.designsystem.block

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.voitenko.dev.galleryspace.designsystem.components.AdaptiveImage
import com.voitenko.dev.galleryspace.designsystem.crystal
import com.voitenko.dev.galleryspace.designsystem.gray3
import com.voitenko.dev.galleryspace.designsystem.modifiers.shimmer


@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Exhibit(
    modifier: Modifier = Modifier,
    image: AsyncImagePainter
) {
    BoxWithConstraints(
        modifier = modifier.aspectRatio(1f), contentAlignment = Alignment.Center
    ) {

        (image.state as? AsyncImagePainter.State.Loading)?.let {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp)
                    .shimmer()
                    .background(color = crystal) // TODO FIX COLOR
            )
        }

        (image.state as? AsyncImagePainter.State.Success)?.result?.drawable?.let {
            AdaptiveImage(
                drawable = it,
                paddingCoefficient = 1.3
            )
        }

        (image.state as? AsyncImagePainter.State.Error)?.let {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                modifier = Modifier.size(56.dp),
                contentDescription = "",
                tint = gray3
            )
        }
    }
}