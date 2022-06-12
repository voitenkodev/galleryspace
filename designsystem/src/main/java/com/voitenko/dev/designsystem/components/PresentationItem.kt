package com.voitenko.dev.designsystem.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.controls.BODY1Text
import com.voitenko.dev.designsystem.controls.CAPTION1Text
import com.voitenko.dev.designsystem.controls.Divider
import com.voitenko.dev.designsystem.controls.H2Text

@Composable
fun PresentationItem(
    url: String, title: String, align: TextAlign, more: () -> Unit
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url.toUri()).size(Size.ORIGINAL).build()
    )

    BoxWithConstraints {

        val maxImageWidth = this.maxWidth / 2

        Column(
            modifier = Modifier
                .padding(top = 44.dp)
                .fillMaxSize()
        ) {
            Title(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(horizontal = 44.dp),
                title = title
            )

            Row(
                modifier = Modifier
                    .padding(top = 24.dp, start = 44.dp, end = 44.dp)
                    .height(80.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier.align(Alignment.Top),
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = GallerySpaceComponent.colors.primaryInverse
                )

                Column(modifier = Modifier.align(Alignment.Bottom)) {
                    CAPTION1Text(text = "created by")
                    BODY1Text(text = "Alfredo Peters")
                }
            }
            Row(modifier = Modifier.height(maxImageWidth)) {
                Column(
                    modifier = Modifier.weight(1f).padding(horizontal = 16.dp, vertical = 16.dp)
                ) {

                    CAPTION1Text(text = "description")

                    BODY1Text(text = "In his essay \"H. P. Lovecraft and the Cthulhu Mythos\", Robert M. Price described two stages in the development of the Cthulhu Mythos. Price called the first stage the \"Cthulhu Mythos proper\". This stage was formulated during Lovecraft's lifetime and was subject to his guidance. The second stage was guided by August Derleth who, in addition to publishing Lovecraft's stories after his death, attempted to categorize and expand the Mythos.")

                }
                Image(
                    modifier = Modifier
                        .weight(1f)
                        .widthIn(max = maxImageWidth),
                    painter = painter
                )
            }

            Divider(modifier = Modifier.padding(start = 44.dp, top = 24.dp))
        }
    }
}

@Composable
private fun Image(modifier: Modifier = Modifier, painter: Painter) = androidx.compose.foundation.Image(
    modifier = modifier
        .wrapContentSize()
        .padding(vertical = 16.dp), painter = painter, contentDescription = null
)

@Composable
private fun Title(modifier: Modifier = Modifier, title: String) = H2Text(
    modifier = modifier,
    text = title,
    maxLines = 3,
)


@ExperimentalUnitApi
@Composable
@Preview(showBackground = true, backgroundColor = 0xFF121311, uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL)
fun PresentationItem_Preview() {
    PresentationItem(url = "https://i.pinimg.com/originals/b2/fa/15/b2fa156ec6baea56cf784cb60af2f17e.jpg",
        title = "Cthulhu Mythos.",
        align = TextAlign.End,
        more = {})
}