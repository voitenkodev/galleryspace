package com.voitenko.dev.designsystem.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
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
    url: String,
    title: String,
    description: String,
    creator: String,
    more: () -> Unit
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url.toUri()).size(Size.ORIGINAL).build()
    )

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
                modifier = Modifier.weight(1f),
                painter = painter
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 16.dp, top = 34.dp),
        color = GallerySpaceComponent.colors.primaryInverse,
    )
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
)

@ExperimentalUnitApi
@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF121311,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
fun PresentationItem_Preview() {
    PresentationItem(
        url = "https://collectionapi.metmuseum.org/api/collection/v1/iiif/591860/1229664/restricted",
        title = "The Treatyse of Fysshynge wyth an Angle from the book of Saint Albans\n1903",
        description = "In 1878 William Loring Andrews became a trustee of The Metropolitan Museum of Art and served as its first librarian. He was a prominent collector of rare books of English and American literature and a founding member of the Grolier Club and the Society of Iconophiles. In 1865 Andrews began to self-publish books in which he was also the author or editor. These works were published in his own taste, through his own direction, and are marked by exquisite taste in type, paper, illustration, and binding. In their production, he engaged the services of engravers Edwin Davis French and S. L. Smith, who designed and engraved bookplates for the Metropolitan Museum, and printers Walter Gillias and Theodore De Vinne. From 1865 to 1908 Andrews issued thirty-six volumes, twenty-six authored by himself. \"The Treatyse of Fysshynge\" was printed on hand-made paper in an edition of 160, at the Gilliss Press; the type, caste specially for the book, was patterned after the traditional Old English characters first used by Wynkyn de Worde. The volume is bound in full limpvellum, with the title gold-tooled on the front cover, and has two green silk ties.",
        creator = "Juliana Berners",
        more = {}
    )
}