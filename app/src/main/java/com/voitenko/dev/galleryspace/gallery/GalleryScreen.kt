package com.voitenko.dev.galleryspace.gallery

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.voitenko.dev.designsystem.modifiers.dragging

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun GalleryScreen() {

    val painters = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Apotheosis.jpg/1200px-Apotheosis.jpg",
        "https://s-t-o-l.com/upload/iblock/55b/13zljj6fqmhxb5g5r31wsiw76q45ov1s.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/d/d9/%D0%A7%D1%91%D1%80%D0%BD%D1%8B%D0%B9_%D1%81%D1%83%D0%BF%D1%80%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82._1915._%D0%93%D0%A2%D0%93.png",
        "https://i.pinimg.com/originals/b2/fa/15/b2fa156ec6baea56cf784cb60af2f17e.jpg",
        "https://veryimportantlot.com/uploads/over/files/%D0%9C%D0%B0%D0%B9%20%D0%A1%D1%82%D0%B0%D1%82%D1%8C%D1%8F%2014%20(1.1)%20%D0%90%D0%B9%D0%B2%D0%B0%D0%B7%D0%BE%D0%B2%D1%81%D0%BA%D0%B8%D0%B9.%20%D0%94%D0%B5%D0%B2%D1%8F%D1%82%D1%8B%D0%B9%20%D0%B2%D0%B0%D0%BB.jpeg",
        "https://top10a.ru/wp-content/uploads/2017/04/10%D0%9F%D0%BE%D0%BB%D0%B5-%D0%BC%D0%B0%D0%BA%D0%BE%D0%B2-%D1%83-%D0%90%D1%80%D0%B6%D0%B0%D0%BD%D1%82%D0%B5%D1%8F.jpg"
    ).map {
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current).data(it.toUri())
                .size(Size.ORIGINAL).build()
        )
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .statusBarsPadding()
    ) {

        painters.forEach {
            Image(
                modifier = Modifier
                    .widthIn(this.maxWidth / 4)
                    .height(this.maxWidth / 2)
                    .dragging()
                    .wrapContentSize(),
                painter = it,
                contentDescription = null
            )
        }
    }
}