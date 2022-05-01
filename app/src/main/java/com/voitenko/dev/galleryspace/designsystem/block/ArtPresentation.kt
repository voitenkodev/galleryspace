package com.voitenko.dev.galleryspace.designsystem.block

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.voitenko.dev.galleryspace.designsystem.components.BODY2Text
import com.voitenko.dev.galleryspace.designsystem.components.BODY3Text
import com.voitenko.dev.galleryspace.designsystem.components.RatingBar
import com.voitenko.dev.galleryspace.designsystem.fourth
import com.voitenko.dev.galleryspace.designsystem.primary
import com.voitenko.dev.galleryspace.designsystem.third
import com.voitenko.dev.galleryspace.designsystem.white

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun ArtPresentation(
    modifier: Modifier = Modifier,
    url: String,
    fraction: Float = 1f,
    content: @Composable BoxScope.() -> Unit
) {

    val image = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url.toUri()).size(Size.ORIGINAL)
            .build()
    )

    Box(modifier = modifier.background(color = primary)) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .alpha(0.3f),
            painter = image,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Exhibit(
            modifier = Modifier.fillMaxWidth(fraction = fraction), image = image
        )

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .aspectRatio(1f)
                .align(Alignment.TopEnd),
            visible = fraction == 0.5f,
            enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
            exit = shrinkHorizontally() + fadeOut()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    BODY2Text(text = "Rating:")
                    RatingBar(
                        modifier = Modifier.height(height = 16.dp),
                        rating = 3.2f,
                        colorEnabled = third,
                        colorDisabled = fourth
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    BODY2Text(text = "Created at:")

                    BODY2Text(
                        text = "16 May, 22",
                        color = white,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    BODY2Text(text = "Sign:")

                    BODY3Text(text = "by Maxim")
                }
            }
        }

        content.invoke(this)
    }
}

