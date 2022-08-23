package designsystem.components

import GallerySpaceComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.controls.RatingBar
import designsystem.controls.*
import loadImage
import models.Person

@Composable
fun PresentationDashboard(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),

    // Art Info
    title: String,
    description: String,
    price: String,
    createdAt: String,

    // Creator
    creator: Person,
    // CoOwners
    people: List<Person>,
) {

    val image = remember { mutableStateOf<ImageBitmap?>(null) }
    LaunchedEffect(Unit) { image.value = loadImage(creator.imageUrl) }

    LazyColumn(
        state = state,
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {
            H1Text(modifier = Modifier.padding(top = 8.dp).padding(horizontal = 16.dp), text = title)
        }

        item {
            BODY2Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp), text = creator.name, textAlign = TextAlign.End
            )
        }

        item {
            Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = GallerySpaceComponent.colors.primaryInverse)
        }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Rating") {
                RatingBar(
                    modifier = Modifier.height(height = 16.dp),
                    rating = 3.5f,
                )
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Created at") {
                BODY2Text(text = createdAt)
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Price") {
                ButtonPrimary(
                    modifier = Modifier,
                    text = price,
                    onClick = { /*TODO*/ },
                    textColor = GallerySpaceComponent.colors.primaryInverse,
                    backgroundColor = GallerySpaceComponent.colors.priceUp
                )
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Owner") {
                image.value?.let {
                    Image(
                        bitmap = it,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(shape = RoundedCornerShape(50)),
                        contentDescription = null
                    )
                }
                BODY2Text(text = creator.name)
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Description", orientation = Orientation.Vertical) {
                BODY1Text(text = description)
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

//        items(people) {
//            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Provenance", orientation = Orientation.Vertical) {
//                Provenance(
//                    modifier = Modifier.fillMaxWidth(),
//                    avatar = it.url,
//                    name = it.name,
//                    date = it.date,
//                    price = it.purchase,
//                    priceColor = it.purchaseColor
//                )
//            }
//        }
    }
}

@Composable
private fun Info(
    modifier: Modifier = Modifier, caption: String, orientation: Orientation = Orientation.Horizontal, content: @Composable () -> Unit
) {
    if (orientation == Orientation.Horizontal) Row(
        modifier = modifier.defaultMinSize(minHeight = 44.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CAPTION1Text(modifier = Modifier.weight(1f), text = caption)
        content.invoke()
    } else Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CAPTION1Text(modifier = Modifier.padding(top = 12.dp), text = caption)
        content.invoke()
    }
}

//@Composable
//private fun Provenance(
//    modifier: Modifier = Modifier,
//    avatar: String,
//    name: String,
//    date: String,
//    price: String,
//    priceColor: Color,
//) {
//
//    val painter = rememberAsyncImagePainter(
//        model = ImageRequest.Builder(LocalContext.current).data(avatar).size(coil.size.Size.ORIGINAL).build()
//    )
//
//    Column(modifier = modifier) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//
//            Image(
//                painter = painter, modifier = Modifier.size(44.dp).clip(shape = RoundedCornerShape(50)), contentDescription = null
//            )
//
//            BODY2Text(modifier = Modifier.weight(1f), text = name)
//
//            Column(horizontalAlignment = Alignment.End) {
//                BODY2Text(text = price, color = priceColor)
//                BODY2Text(text = date)
//            }
//        }
//    }
//}