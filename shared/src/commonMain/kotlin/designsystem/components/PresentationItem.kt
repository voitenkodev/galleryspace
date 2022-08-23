package designsystem.components

import GallerySpaceComponent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import designsystem.controls.BODY1Text
import designsystem.controls.CAPTION1Text
import designsystem.controls.Divider
import designsystem.controls.H2Text
import designsystem.modifiers.parallelepiped
import loadImage

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun PresentationItem(
    uri: String,
    title: String,
    description: String,
    creator: String,
    more: () -> Unit
) {
    val img = remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) { img.value = loadImage(uri) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 44.dp)
    ) {

        Title(title = title)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 16.dp)
        ) {
            Icon(
                modifier = Modifier.clickable { more.invoke() },
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = GallerySpaceComponent.colors.primaryInverse
            )
        }
        Column(modifier = Modifier.align(Alignment.End), horizontalAlignment = Alignment.End) {
            CAPTION1Text(text = "created by")
            BODY1Text(text = creator)
        }

        Row(
            modifier = Modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp),
            ) {
                CAPTION1Text(text = "description")
                BODY1Text(text = description, maxLines = 4)
            }
            Image(
                modifier = Modifier.weight(1f)
                    .parallelepiped(
                        -15f,
                        15f,
                        1f,
                        GallerySpaceComponent.colors.primaryInverse,
                        GallerySpaceComponent.colors.primaryInverse
                    ),
                bitmap = img.value,
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 16.dp, top = 34.dp),
        color = GallerySpaceComponent.colors.primaryInverse,
    )
}

@Composable
private fun Image(modifier: Modifier = Modifier, bitmap: ImageBitmap?) = bitmap?.let {
    androidx.compose.foundation.Image(
        modifier = modifier
            .wrapContentSize(), bitmap = bitmap, contentDescription = null
    )
}

@Composable
private fun Title(modifier: Modifier = Modifier, title: String) = H2Text(
    modifier = modifier,
    text = title,
)