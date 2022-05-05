package com.voitenko.dev.galleryspace.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.voitenko.dev.galleryspace.designsystem.block.ArtInfoColumn
import com.voitenko.dev.galleryspace.designsystem.block.ArtInfoRow
import com.voitenko.dev.galleryspace.designsystem.block.Exhibit
import com.voitenko.dev.galleryspace.designsystem.block.Toolbar
import com.voitenko.dev.galleryspace.designsystem.components.BODY1Text
import com.voitenko.dev.galleryspace.designsystem.components.H1Text
import com.voitenko.dev.galleryspace.designsystem.primary

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PresentPictureScreen() {

    val title = "Pollard Birches"
    val sign = "by Salvador Dalí"
    val description =
        "Vincent van Gogh (1853 - 1890), Nuenen, March 1884\n" + "\n" + "pencil, pen and ink, watercolour, on paper, 39.5 cm x 54.2 cm\n" + "\n" + "Credits (obliged to state): Van Gogh Museum, Amsterdam (Vincent van Gogh Foundation)\n" + "\n" + "Van Gogh loved pollard trees with their gnarled trunks. They feature prominently in many of his paintings and drawings, including this one. In a letter to his brother Theo, he compared a row of pollard trees to a 'procession of orphan men'. What he meant was that nature had a soul of its own.\n" + "\n" + "This work is part of a series of seven pen and ink drawings of Brabant landscapes from 1884. The compositions are compelling. The way he drew it, with a great deal of hatching, shows his individual style. The drawings form a high point of Van Gogh's work in the Netherlands. " +
                "Vincent van Gogh (1853 - 1890), Nuenen, March 1884\\n\" + \"\\n\" + \"pencil, pen and ink, watercolour, on paper, 39.5 cm x 54.2 cm\\n\" + \"\\n\" + \"Credits (obliged to state): Van Gogh Museum, Amsterdam (Vincent van Gogh Foundation)\\n\" + \"\\n\" + \"Van Gogh loved pollard trees with their gnarled trunks. They feature prominently in many of his paintings and drawings, including this one. In a letter to his brother Theo, he compared a row of pollard trees to a 'procession of orphan men'. What he meant was that nature had a soul of its own.\\n\" + \"\\n\" + \"This work is part of a series of seven pen and ink drawings of Brabant landscapes from 1884. The compositions are compelling. The way he drew it, with a great deal of hatching, shows his individual style. The drawings form a high point of Van Gogh's work in the Netherlands."
    val image =
//    "https://s-t-o-l.com/upload/iblock/55b/13zljj6fqmhxb5g5r31wsiw76q45ov1s.jpg"
//        "https://upload.wikimedia.org/wikipedia/commons/d/d9/%D0%A7%D1%91%D1%80%D0%BD%D1%8B%D0%B9_%D1%81%D1%83%D0%BF%D1%80%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82._1915._%D0%93%D0%A2%D0%93.png"
//        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Apotheosis.jpg/1200px-Apotheosis.jpg"
//        "https://i.pinimg.com/originals/b2/fa/15/b2fa156ec6baea56cf784cb60af2f17e.jpg"
//        "https://veryimportantlot.com/uploads/over/files/%D0%9C%D0%B0%D0%B9%20%D0%A1%D1%82%D0%B0%D1%82%D1%8C%D1%8F%2014%20(1.1)%20%D0%90%D0%B9%D0%B2%D0%B0%D0%B7%D0%BE%D0%B2%D1%81%D0%BA%D0%B8%D0%B9.%20%D0%94%D0%B5%D0%B2%D1%8F%D1%82%D1%8B%D0%B9%20%D0%B2%D0%B0%D0%BB.jpeg"
        "https://top10a.ru/wp-content/uploads/2017/04/10%D0%9F%D0%BE%D0%BB%D0%B5-%D0%BC%D0%B0%D0%BA%D0%BE%D0%B2-%D1%83-%D0%90%D1%80%D0%B6%D0%B0%D0%BD%D1%82%D0%B5%D1%8F.jpg"

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(image.toUri())
            .size(Size.ORIGINAL).build()
    )

    val fraction = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1.0f else 0.5f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val alpha = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 0.5f else 0.9f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painter,
        contentDescription = "",
        contentScale = ContentScale.Crop
    )

    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    0f to primary.copy(0.8f),
                    0.5f to primary.copy(alpha.value)
                )
            )
    )

    BoxWithConstraints(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        val space = 8.dp
        val toolbar = 44.dp
        val appInfoRow = 56.dp
        val collapsedBottomSheetHeight =
            this.maxHeight - this.maxWidth - toolbar - appInfoRow - space
        val expandedBottomSheetHeight = this.maxHeight - (this.maxWidth / 2) - toolbar

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            backgroundColor = Color.Transparent,
            sheetBackgroundColor = Color.Transparent,
            sheetPeekHeight = collapsedBottomSheetHeight,
            sheetElevation = 0.dp,
            sheetContent = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(expandedBottomSheetHeight),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        H1Text(
                            text = title,
                        )
                    }
                    item {
                        BODY1Text(
                            text = description,
                        )
                    }
                }
            },
            content = {

                Box {

                    Toolbar()

                    Exhibit(
                        modifier = Modifier
                            .padding(top = toolbar)
                            .fillMaxWidth(fraction = fraction.value),
                        image = painter
                    )

                    ArtInfoColumn(
                        modifier = Modifier
                            .padding(top = toolbar)
                            .fillMaxWidth(0.5f)
                            .aspectRatio(1f)
                            .align(Alignment.TopEnd),
                        visibility = fraction.value == 0.5f
                    )

                    ArtInfoRow(
                        modifier = Modifier
                            .padding(top = this@BoxWithConstraints.maxWidth + toolbar)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .height(appInfoRow),
                        visibility = fraction.value == 1f
                    )
                }
            }
        )
    }
}