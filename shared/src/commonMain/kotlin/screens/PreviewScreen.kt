package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import designsystem.components.PresentationDashboard
import loadImage
import models.Art

@Composable
fun PreviewScreen() {

    val art = Art.MOCK

    val image = remember { mutableStateOf<ImageBitmap?>(null) }
    LaunchedEffect(Unit) { image.value = loadImage(art.url) }

    val listState: LazyListState = rememberLazyListState()

    Column {
        Box(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {

            image.value?.let {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.3f),
                    bitmap = it,
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )

                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(vertical = 16.dp)
                        .wrapContentSize(),
                    bitmap = it,
                    contentDescription = null
                )
            }
        }

        PresentationDashboard(
            state = listState,
            modifier = Modifier
                .fillMaxWidth(),
            title = art.title,
            description = art.description,
            creator = art.creator,
            price = art.price,
            createdAt = art.createdAt,
            people = emptyList(),
        )
    }
}