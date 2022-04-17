package com.voitenko.dev.galleryspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size.Companion.ORIGINAL
import com.voitenko.dev.galleryspace.ui.designsystem.*
import com.voitenko.dev.galleryspace.ui.designsystem.components.BODY2Text
import com.voitenko.dev.galleryspace.ui.designsystem.components.BODY3Text
import com.voitenko.dev.galleryspace.ui.designsystem.components.H1Text
import com.voitenko.dev.galleryspace.ui.designsystem.modifiers.neumorph
import com.voitenko.dev.galleryspace.ui.designsystem.modifiers.rolling

@ExperimentalComposeUiApi
@ExperimentalUnitApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GallerySpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Greeting() {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://dmn-dallas-news-prod.cdn.arcpublishing.com/resizer/Q3MPgXlouXWPujS8AxihDXlwqbw=/1660x934/smart/filters:no_upscale()/cloudfront-us-east-1.images.arcpublishing.com/dmn/BR2GB24AWVFYXA5EDFM4YPSWQ4.jpg")
//            .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTY5VRkGXGr6oUsXdApP-UdtVeBikwHjCl6Q&usqp=CAU")
            .size(ORIGINAL).build()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(crystal)
            .padding(top = 40.dp)
            .padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = gray2, shape = RoundedCornerShape(16.dp))
                .aspectRatio(1f)
                .neumorph(
                    radius = 16.dp,
                    pressed = true,
                    shadow1 = gray3,
                    shadow2 = white,
                ), contentAlignment = Alignment.Center
        ) {


            (painter.state as? AsyncImagePainter.State.Success)?.result?.drawable?.let {

                val imageHeight = it.intrinsicHeight.toFloat()
                val imageWidth = it.intrinsicWidth.toFloat()
                val percentK = 1.5
                val height = if (imageHeight > imageWidth) maxHeight.value / percentK
                else maxHeight.value / (imageWidth / imageHeight) / percentK
                val width = if (imageHeight < imageWidth) maxWidth.value / percentK
                else maxWidth.value / (imageHeight / imageWidth) / percentK

                Image(
                    modifier = Modifier
                        .rolling()
                        .size(width = width.dp, height = height.dp)
                        .clip(RoundedCornerShape(0.dp)),
                    painter = painter,
                    contentDescription = ""
                )
            }

            BODY3Text(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 8.dp),
                text = "by Max"
            )
        }

        H1Text(text = "Van Gogh")

        BODY2Text(text = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.")
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GallerySpaceTheme {
        Greeting()
    }
}