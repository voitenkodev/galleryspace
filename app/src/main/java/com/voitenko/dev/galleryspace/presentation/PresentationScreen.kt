package com.voitenko.dev.galleryspace.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.components.Toolbar
import com.voitenko.dev.designsystem.controls.*
import com.voitenko.dev.designsystem.modifiers.rolling

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PresentPictureScreen() {

    val title = "Cthulhu Mythos."
    val creator = "by H. P. Lovecraft"
    val owner = "Olivie Piero"
    val createdAt = "16 May, 22"
    val price = "0.251 BTC"
    val description =
        "In his essay \"H. P. Lovecraft and the Cthulhu Mythos\", Robert M. Price described two stages in the development of the Cthulhu Mythos. Price called the first stage the \"Cthulhu Mythos proper\". This stage was formulated during Lovecraft's lifetime and was subject to his guidance. The second stage was guided by August Derleth who, in addition to publishing Lovecraft's stories after his death, attempted to categorize and expand the Mythos."
    val image =
        "https://render.fineartamerica.com/images/rendered/search/print/6.5/8/break/images-medium-5/call-of-cthulhu-armand-cabrera.jpg"
//        "https://www.neilbuchanan.co.uk/uploads/6/6/9/5/66951261/published/16-11-woolly-mammoth.jpeg?1591877159"

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    val listState: LazyListState = rememberLazyListState()

    val fraction = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1.0f else 0.5f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val background = animateColorAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) GallerySpaceComponent.colors.primary else GallerySpaceComponent.colors.secondary,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val thicknessCoefficient = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1f else 0.5f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val titleVisible = (listState.firstVisibleItemIndex == 0).not()

    BoxWithConstraints(
        modifier = Modifier
            .background(background.value)
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
            sheetBackgroundColor = GallerySpaceComponent.colors.primary,
            sheetPeekHeight = collapsedBottomSheetHeight,
            sheetElevation = 0.dp,
            content = {
                Header(
                    fraction = fraction.value,
                    thicknessCoefficient = thicknessCoefficient.value,
                    titleVisible = titleVisible,
                    url = image,
                    title = title
                )
            },
            sheetContent = {
                SheetContent(
                    state = listState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(height = expandedBottomSheetHeight),
                    title = title,
                    description = description,
                    creator = creator,
                    price = price,
                    createdAt = createdAt,
                    owner = owner
                )
            },
        )
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Header(
    fraction: Float,
    thicknessCoefficient: Float,
    titleVisible: Boolean,
    url: String,
    title: String,
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url.toUri()).size(coil.size.Size.ORIGINAL).build()
    )

    Column {

        Toolbar()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = fraction)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center,
            ) {

                Image(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .wrapContentSize()
                        .rolling(
                            sideColor1 = Color.LightGray,
                            sideColor2 = Color.LightGray,
                            thicknessCoefficient = thicknessCoefficient
                        ),
                    painter = painter,
                    contentDescription = null
                )
            }

            AnimatedVisibility(
                visible = titleVisible,
                enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
                exit = shrinkHorizontally() + fadeOut(),
                content = { H2Text(modifier = Modifier.padding(start = 16.dp), text = title, maxLines = 3) })
        }
    }
}

@Composable
private fun SheetContent(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    title: String,
    description: String,
    creator: String,
    price: String,
    createdAt: String,
    owner: String,
) {
    LazyColumn(
        state = state,
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item { H1Text(modifier = Modifier.padding(top = 8.dp), text = title) }

        item { BODY2Text(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), text = creator) }

        item { Divider(thickness = 2.dp, color = GallerySpaceComponent.colors.primaryInverse) }

        Info(rating = 3.5f, price = price, createdAt = createdAt, owner = owner)

        item {
            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "Buy - $ 999",
                onClick = { /*TODO*/ }
            )
        }

        item { CAPTION1Text(text = "Description") }

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

        item { CAPTION1Text(text = "Provenance") }

    }
}

fun LazyListScope.Info(
    rating: Float,
    price: String,
    createdAt: String,
    owner: String,
) {
    item {
        Row(
            Modifier
                .fillMaxSize()
                .height(44.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CAPTION1Text(text = "Rating")
            RatingBar(
                modifier = Modifier.height(height = 16.dp),
                rating = rating,
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
            CAPTION1Text(text = "Price")
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
            CAPTION1Text(text = "Created at")
            BODY2Text(text = createdAt)
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
            CAPTION1Text(text = "Owner ")
            BODY2Text(text = owner)
        }
    }
}

@Composable
fun LazyListScope.Provenance() {

}