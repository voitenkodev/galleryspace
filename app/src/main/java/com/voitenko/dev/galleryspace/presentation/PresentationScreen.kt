package com.voitenko.dev.galleryspace.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
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
import com.voitenko.dev.designsystem.components.Owner
import com.voitenko.dev.designsystem.components.PresentationDashboard
import com.voitenko.dev.designsystem.components.Toolbar
import com.voitenko.dev.designsystem.controls.H2Text
import com.voitenko.dev.designsystem.modifiers.rolling

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PresentPictureScreen() {

    val title = "Cthulhu Mythos."
    val creator = "by H. P. Lovecraft"
    val createdAt = "16 May, 22"
    val price = "0.251 BTC"
    val description =
        "In his essay \"H. P. Lovecraft and the Cthulhu Mythos\", Robert M. Price described two stages in the development of the Cthulhu Mythos. Price called the first stage the \"Cthulhu Mythos proper\". This stage was formulated during Lovecraft's lifetime and was subject to his guidance. The second stage was guided by August Derleth who, in addition to publishing Lovecraft's stories after his death, attempted to categorize and expand the Mythos."
    val image =
//        "https://render.fineartamerica.com/images/rendered/search/print/6.5/8/break/images-medium-5/call-of-cthulhu-armand-cabrera.jpg"
        "https://www.neilbuchanan.co.uk/uploads/6/6/9/5/66951261/published/16-11-woolly-mammoth.jpeg?1591877159"
    val owners = listOf(
        Owner(
            name = "Philip K. Howard",
            url = "https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg",
            purchase = "1.2224 BTC",
            purchaseColor = GallerySpaceComponent.colors.priceUp,
            date = "10.11.2022"
        ),
        Owner(
            name = "Alfredo Peters",
            url = "https://miro.medium.com/max/1400/0*E-e0EHOU1Fvxtuis.jpg",
            purchase = "0.0054 BTC",
            purchaseColor = GallerySpaceComponent.colors.priceUp,
            date = "16.09.2019"
        ),
        Owner(
            name = "Michiel Vernandos",
            url = "https://globalmsk.ru/usr/person/big-person-15642469881.jpg",
            purchase = "127 $",
            purchaseColor = GallerySpaceComponent.colors.priceDown,
            date = "26.08.2016"
        ),
        Owner(
            name = "Van Gogh",
            url = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg",
            purchase = "142 $",
            purchaseColor = GallerySpaceComponent.colors.priceUp,
            date = "01.01.2008"
        ),
    )


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
                PresentationDashboard(
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
                    owners = owners
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
                            sideColor1 = Color.LightGray, sideColor2 = Color.LightGray, thicknessCoefficient = thicknessCoefficient
                        ), painter = painter, contentDescription = null
                )
            }

            AnimatedVisibility(visible = titleVisible,
                enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
                exit = shrinkHorizontally() + fadeOut(),
                content = { H2Text(modifier = Modifier.padding(start = 16.dp), text = title, maxLines = 3) })
        }
    }
}