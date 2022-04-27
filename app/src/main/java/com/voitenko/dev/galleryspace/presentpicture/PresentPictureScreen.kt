package com.voitenko.dev.galleryspace.presentpicture

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.voitenko.dev.galleryspace.designsystem.*
import com.voitenko.dev.galleryspace.designsystem.components.*
import com.voitenko.dev.galleryspace.designsystem.modifiers.neu
import com.voitenko.dev.galleryspace.designsystem.modifiers.shimmer

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PresentPictureScreen() {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/%D0%A7%D1%91%D1%80%D0%BD%D1%8B%D0%B9_%D1%81%D1%83%D0%BF%D1%80%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82._1915._%D0%93%D0%A2%D0%93.png/350px-%D0%A7%D1%91%D1%80%D0%BD%D1%8B%D0%B9_%D1%81%D1%83%D0%BF%D1%80%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82._1915._%D0%93%D0%A2%D0%93.png".toUri())
            .size(Size.ORIGINAL).build()
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(crystal)
            .padding(top = 24.dp)
            .padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = gray1, shape = RoundedCornerShape(16.dp))
                .aspectRatio(1f)
                .neu(
                    radius = 16.dp,
                    pressed = true,
                    shadow1 = gray3,
                    shadow2 = white,
                ), contentAlignment = Alignment.Center
        ) {

            (painter.state as? AsyncImagePainter.State.Loading)?.let {
                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(3.dp)
                        .shimmer()
                        .background(color = crystal, shape = RoundedCornerShape(16.dp))
                )
            }

            (painter.state as? AsyncImagePainter.State.Success)?.result?.drawable?.let {
                AdaptiveImage(
                    drawable = it, paddingCoefficient = 1.5
                )
            }

            (painter.state as? AsyncImagePainter.State.Error)?.let {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    modifier = Modifier.size(56.dp),
                    contentDescription = "",
                    tint = gray3
                )
            }

            BODY3Text(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 8.dp),
                text = "by Max"
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            H1Text(
                text = "Van Gogh"
            )

            RatingBar(
                modifier = Modifier.height(20.dp),
                rating = 2.7f,
                colorEnabled = darkYellow,
                colorDisabled = gray3
            )
        }

        BODY2Text(
            text = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."
        )
    }
}