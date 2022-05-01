package com.voitenko.dev.galleryspace.presentpicture

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voitenko.dev.galleryspace.designsystem.block.ArtPresentation
import com.voitenko.dev.galleryspace.designsystem.block.Toolbar
import com.voitenko.dev.galleryspace.designsystem.components.BODY2Text
import com.voitenko.dev.galleryspace.designsystem.components.BODY3Text
import com.voitenko.dev.galleryspace.designsystem.components.H1Text
import com.voitenko.dev.galleryspace.designsystem.primary
import com.voitenko.dev.galleryspace.designsystem.secondary
import com.voitenko.dev.galleryspace.designsystem.third

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
//        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Apotheosis.jpg/1200px-Apotheosis.jpg"
        "https://i.pinimg.com/originals/b2/fa/15/b2fa156ec6baea56cf784cb60af2f17e.jpg"

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    val fraction = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1.0f else 0.5f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )
    val color = animateColorAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) secondary else primary,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val radius = animateDpAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 8.dp else 8.dp,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val toolbar = 44.dp
        val spacer = 8.dp + toolbar
        val collapsedBottomSheetHeight = this.maxHeight - this.maxWidth - spacer
        val expandedBottomSheetHeight = this.maxHeight - (this.maxWidth / 2) - spacer

        BottomSheetScaffold(scaffoldState = scaffoldState,
            backgroundColor = color.value,
            sheetBackgroundColor = secondary,
            sheetPeekHeight = collapsedBottomSheetHeight,
            sheetElevation = 0.dp,
            sheetContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(expandedBottomSheetHeight)
                ) {
                    H1Text(
                        modifier = Modifier.padding(bottom = 6.dp),
                        text = title,
                    )

                    BODY2Text(
                        modifier = Modifier.padding(vertical = 16.dp),
                        text = description,
                    )
                }
            },
            content = {

                Toolbar()

                ArtPresentation(
                    url = image,
                    fraction = fraction.value,
                ) {
                        BODY3Text(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(end = 16.dp, bottom = 8.dp),
                            text = sign,
                            color = third
                        )
                }
            }
        )
    }
}