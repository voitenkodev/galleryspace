package com.voitenko.dev.designsystem.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.common.GallerySpaceTheme
import com.voitenko.dev.designsystem.controls.*

data class Owner(
    val name: String,
    val url: String,
    val purchase: String,
    val purchaseColor: Color,
    val date: String
)

@Composable
fun PresentationDashboard(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    // Art Info
    title: String,
    description: String,
    creator: String,
    price: String,
    createdAt: String,
    // Owners
    owners: List<Owner>,
) {

    val owner = owners.firstOrNull()

    val ownerPhoto = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(owner?.url?.toUri()).size(coil.size.Size.ORIGINAL).build()
    )

    LazyColumn(
        state = state, modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item { H1Text(modifier = Modifier.padding(top = 8.dp), text = title) }

        item { BODY2Text(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), text = creator) }

        item {
            Divider(thickness = 1.dp, color = GallerySpaceComponent.colors.primaryInverse)
        }

        item {
            Info(caption = "Rating") {
                RatingBar(
                    modifier = Modifier.height(height = 16.dp),
                    rating = 3.5f,
                )
            }
        }

        item { Divider() }

        item {
            Info(caption = "Created at") {
                BODY2Text(text = createdAt)
            }
        }

        item { Divider() }

        item {
            Info(caption = "Price") {
                ButtonPrimary(
                    modifier = Modifier,
                    text = price,
                    onClick = { /*TODO*/ },
                    textColor = GallerySpaceComponent.colors.primaryInverse,
                    backgroundColor = GallerySpaceComponent.colors.priceUp
                )
            }
        }

        item { Divider() }

        item {
            Info(caption = "Owner") {
                Image(
                    painter = ownerPhoto,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(shape = RoundedCornerShape(50)),
                    contentDescription = null
                )
                BODY2Text(text = owner?.name)
            }
        }

        item { Divider() }

        item {
            Info(caption = "Description", orientation = Orientation.Vertical) {
                BODY1Text(text = description)
            }
        }

        item { Divider() }

        item {
            Info(caption = "Provenance", orientation = Orientation.Vertical) {
                owners.forEach {
                    Provenance(
                        modifier = Modifier.fillMaxWidth(),
                        avatar = it.url,
                        name = it.name,
                        date = it.date,
                        price = it.purchase,
                        priceColor = it.purchaseColor
                    )
                }
            }
        }
    }
}

@Composable
private fun Info(
    modifier: Modifier = Modifier,
    caption: String,
    orientation: Orientation = Orientation.Horizontal,
    content: @Composable () -> Unit
) {
    if (orientation == Orientation.Horizontal) Row(
        modifier = modifier
            .defaultMinSize(minHeight = 44.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CAPTION1Text(modifier = Modifier.weight(1f), text = caption)
        content.invoke()
    } else Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CAPTION1Text(modifier = Modifier.padding(top = 12.dp), text = caption)
        content.invoke()
    }
}

@Composable
private fun Provenance(
    modifier: Modifier = Modifier,
    avatar: String,
    name: String,
    date: String,
    price: String,
    priceColor: Color,
) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(avatar.toUri()).size(coil.size.Size.ORIGINAL).build()
    )

    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Image(
                painter = painter,
                modifier = Modifier
                    .size(44.dp)
                    .clip(shape = RoundedCornerShape(50)),
                contentDescription = null
            )

            BODY2Text(modifier = Modifier.weight(1f), text = name)

            Column(horizontalAlignment = Alignment.End) {
                BODY2Text(text = price, color = priceColor)
                BODY2Text(text = date)
            }
        }
    }
}

@ExperimentalUnitApi
@Composable
@Preview(showBackground = true, backgroundColor = 0xFF121311, uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL)
private fun PresentationDashboard_Preview() {
    GallerySpaceTheme {
        PresentationDashboard(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            title = "Cthulhu Mythos.",
            description = "In his essay \"H. P. Lovecraft and the Cthulhu Mythos\", Robert M. Price described two stages in the development of the Cthulhu Mythos. Price called the first stage the \"Cthulhu Mythos proper\". This stage was formulated during Lovecraft's lifetime and was subject to his guidance. The second stage was guided by August Derleth who, in addition to publishing Lovecraft's stories after his death, attempted to categorize and expand the Mythos.",
            creator = "by H. P. Lovecraft",
            price = "0.251 BTC",
            createdAt = "16 May, 22",
            owners = listOf(
                Owner(
                    name = "Philip K. Howard",
                    url = "https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg",
                    purchase = "1.2224 BTC",
                    purchaseColor = GallerySpaceComponent.colors.priceUp,
                    date = "10.11.2022"
                ),
                Owner(
                    name = "Alfredo Peters",
                    url = "https://miro.medium.com/max/1400/0*E-e0EHOU1Fvxtuis.jpg",
                    purchase = "0.0054 BTC",
                    purchaseColor = GallerySpaceComponent.colors.priceUp,
                    date = "16.09.2019"
                ),
                Owner(
                    name = "Michiel Vernandos",
                    url = "https://globalmsk.ru/usr/person/big-person-15642469881.jpg",
                    purchase = "127 $",
                    purchaseColor = GallerySpaceComponent.colors.priceDown,
                    date = "26.08.2016"
                ),
                Owner(
                    name = "Van Gogh",
                    url = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg",
                    purchase = "142 $",
                    purchaseColor = GallerySpaceComponent.colors.priceUp,
                    date = "01.01.2008"
                ),
            )
        )
    }
}