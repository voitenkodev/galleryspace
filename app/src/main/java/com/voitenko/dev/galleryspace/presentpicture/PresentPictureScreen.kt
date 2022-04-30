package com.voitenko.dev.galleryspace.presentpicture

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.voitenko.dev.galleryspace.designsystem.components.AdaptiveImage
import com.voitenko.dev.galleryspace.designsystem.components.BODY2Text
import com.voitenko.dev.galleryspace.designsystem.components.BODY3Text
import com.voitenko.dev.galleryspace.designsystem.components.H1Text
import com.voitenko.dev.galleryspace.designsystem.crystal
import com.voitenko.dev.galleryspace.designsystem.crystalDark
import com.voitenko.dev.galleryspace.designsystem.gray3
import com.voitenko.dev.galleryspace.designsystem.modifiers.neu
import com.voitenko.dev.galleryspace.designsystem.modifiers.shimmer
import com.voitenko.dev.galleryspace.designsystem.white

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PresentPictureScreen() {

    val title = "La persistencia de la memoria"
    val sign = "by Salvador Dalí"
    val description =
        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."
    val image =
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Apotheosis.jpg/1200px-Apotheosis.jpg"

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    val fraction = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1.0f else 0.5f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )
    val color = animateColorAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) crystal else crystalDark,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val elevation = animateDpAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 0.dp else 2.dp,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val spacer = 24.dp
        val collapsedBottomSheetHeight = this.maxHeight - this.maxWidth - spacer
        val expandedBottomSheetHeight = this.maxHeight - (this.maxWidth / 2) - spacer

        BottomSheetScaffold(scaffoldState = scaffoldState,
            backgroundColor = color.value,
            sheetBackgroundColor = crystal,
            sheetPeekHeight = collapsedBottomSheetHeight,
            sheetElevation = elevation.value,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(expandedBottomSheetHeight)
                ) {
                    Column {
                        H1Text(
                            modifier = Modifier.padding(bottom = 6.dp),
                            text = title,
                        )

                        BODY2Text(
                            modifier = Modifier.padding(vertical = 16.dp),
                            text = description,
                        )
                    }
                }
            },
            content = {
                ArtPresentation(
                    modifier = Modifier.padding(16.dp),
                    url = image,
                    sign = sign,
                    fraction = fraction.value
                )
            })
    }
}

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
private fun ArtPresentation(
    modifier: Modifier = Modifier,
    url: String,
    sign: String,
    fraction: Float = 1f,
) {

    val image = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url.toUri()).size(Size.ORIGINAL)
            .build()
    )

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth(fraction = fraction)
            .padding(top = 8.dp, bottom = 8.dp)
            .aspectRatio(1f), contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp))
                .alpha(0.4f),
            painter = image,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        (image.state as? AsyncImagePainter.State.Loading)?.let {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp)
                    .shimmer()
                    .background(color = crystal, shape = RoundedCornerShape(16.dp))
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
                .neu(
                    radius = 16.dp,
                    pressed = true,
                    shadow1 = gray3,
                    shadow2 = white,
                )
        )

        (image.state as? AsyncImagePainter.State.Success)?.result?.drawable?.let {
            AdaptiveImage(
                drawable = it, paddingCoefficient = 1.2
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

        BODY3Text(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 8.dp),
            text = sign
        )
    }
}