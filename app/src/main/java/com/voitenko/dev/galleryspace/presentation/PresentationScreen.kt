package com.voitenko.dev.galleryspace.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.components.ArtInfoColumn
import com.voitenko.dev.designsystem.components.Toolbar
import com.voitenko.dev.designsystem.controls.*
import com.voitenko.dev.designsystem.modifiers.neu
import com.voitenko.dev.designsystem.modifiers.rolling

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PresentPictureScreen() {

    val title = "The Starry Night, 1889."
    val sign = "by Salvador Dalí."
    val createdAt = "16 May, 22"
    val price = "279$"
    val description =
        "Vincent van Gogh (1853 - 1890), Nuenen, March 1884 pencil, pen and ink, watercolour, on paper, 39.5 cm x 54.2 cm Credits (obliged to state): Van Gogh Museum, Amsterdam (Vincent van Gogh Foundation) The way he drew it, with a great deal of hatching, shows his individual style. The drawings form a high point of Van Gogh's work in the Netherlands."
    val image =
        "https://veryimportantlot.com/uploads/over/files/%D0%9C%D0%B0%D0%B9%20%D0%A1%D1%82%D0%B0%D1%82%D1%8C%D1%8F%2014%20(1.1)%20%D0%90%D0%B9%D0%B2%D0%B0%D0%B7%D0%BE%D0%B2%D1%81%D0%BA%D0%B8%D0%B9.%20%D0%94%D0%B5%D0%B2%D1%8F%D1%82%D1%8B%D0%B9%20%D0%B2%D0%B0%D0%BB.jpeg"

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    val fraction = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1.0f else 0.5f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    BoxWithConstraints(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        val space = 8.dp
        val toolbar = 44.dp
        val collapsedBottomSheetHeight = this.maxHeight - this.maxWidth - toolbar - space
        val expandedBottomSheetHeight = this.maxHeight - (this.maxWidth / 2) - toolbar

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            backgroundColor = Color.Transparent,
            sheetBackgroundColor = Color.Transparent,
            sheetPeekHeight = collapsedBottomSheetHeight,
            sheetElevation = 0.dp,
            content = {
                Header(
                    url = image,
                    fraction = fraction.value,
                    sign = sign,
                    price = price,
                    createdAt = createdAt
                )
            },
            sheetContent = {
                SheetContent(
                    height = expandedBottomSheetHeight,
                    title = title,
                    sign = sign,
                    description = description,
                    price = price,
                    createdAt = createdAt
                )
            },
        )
    }
}

@Composable
private fun ColumnScope.SheetContent(
    height: Dp,
    title: String,
    description: String,
    sign: String,
    price: String,
    createdAt: String,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(height = height),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item { H1Text(text = title) }

        item { BODY2Text(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), text = sign) }

        item { Divider() }

        item {
            Row(
                Modifier
                    .fillMaxSize()
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CAPTIONText(text = "Rating")
                RatingBar(
                    modifier = Modifier.height(height = 16.dp),
                    rating = 3.2f,
                )
            }
        }

        item { Divider() }

        item {
            Row(
                Modifier
                    .fillMaxSize()
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CAPTIONText(text = "Price")
                BODY2Text(text = price)
            }
        }

        item { Divider() }

        item {
            Row(
                Modifier
                    .fillMaxSize()
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CAPTIONText(text = "Created at")
                BODY2Text(text = createdAt)
            }
        }

        item { Divider() }

        item {
            ButtonPrimary(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp), text = "Buy - $ 999", onClick = { /*TODO*/ })
        }

        item { BODY1Text(text = description) }

        item {
            ButtonSecondary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "Add to favorite",
                onClick = { /*TODO*/ },
                leadIcon = Icons.Default.FavoriteBorder
            )
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Header(
    fraction: Float,
    url: String,
    sign: String,
    price: String,
    createdAt: String,

    ) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url.toUri()).size(coil.size.Size.ORIGINAL).build()
    )

    Column {

        Toolbar()

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth(fraction = fraction)
                    .aspectRatio(1f), contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(34.dp)
                        .wrapContentSize()
                        .rolling()
                ) {
                    Image(
                        modifier = Modifier.wrapContentSize(), painter = painter, contentDescription = null
                    )
                    Spacer(
                        modifier = Modifier
                            .matchParentSize()
                            .neu(
                                pressed = true,
                                shadow1 = GallerySpaceComponent.colors.primaryInverse,
                                shadow2 = GallerySpaceComponent.colors.primaryInverse,
                                elevation = 2.dp
                            )
                    )
                }
            }
            ArtInfoColumn(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .aspectRatio(1f)
                    .align(Alignment.TopEnd),
                visibility = fraction == 0.5f
            )
        }
    }
}