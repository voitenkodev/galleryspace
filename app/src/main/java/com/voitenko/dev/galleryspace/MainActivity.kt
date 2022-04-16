package com.voitenko.dev.galleryspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.voitenko.dev.galleryspace.ui.designsystem.*
import com.voitenko.dev.galleryspace.ui.designsystem.components.BODY2Text
import com.voitenko.dev.galleryspace.ui.designsystem.components.H1Text
import com.voitenko.dev.galleryspace.ui.designsystem.modifiers.neumorph
import com.voitenko.dev.galleryspace.ui.designsystem.modifiers.rotator

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
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
                    shadow2 = gray,
                ), contentAlignment = Alignment.Center
        ) {
            val width = maxWidth.value / 1.5

            Box(
                modifier = Modifier
                    .size(width.dp)
                    .rotator()
                    .neumorph(
                        radius = 16.dp,
                        pressed = false,
                        shadow1 = gray3,
                        shadow2 = gray3,
                        elevation = 6.dp
                    )
                    .background(Color.White, RoundedCornerShape(16.dp)),
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://zimamagazine.com/wp-content/uploads/2019/05/zvezdnaya-noch-nad-ronoi-600x400.jpg")
                        .crossfade(true).build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                )
            }
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