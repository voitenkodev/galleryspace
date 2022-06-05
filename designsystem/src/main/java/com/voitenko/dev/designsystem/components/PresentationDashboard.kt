package com.voitenko.dev.designsystem.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.common.GallerySpaceTheme
import com.voitenko.dev.designsystem.controls.*

@Composable
private fun PresentationDashboard(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    title: String,
    description: String,
    creator: String,
    price: String,
    createdAt: String,
    owner: String,
) {
    LazyColumn(
        state = state,
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item { H1Text(modifier = Modifier.padding(top = 8.dp), text = title) }

        item { BODY2Text(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), text = creator) }

        item { Divider(thickness = 2.dp, color = GallerySpaceComponent.colors.primaryInverse) }

        item {
            Row(
                Modifier
                    .fillMaxSize()
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CAPTION1Text(text = "Rating")
                RatingBar(
                    modifier = Modifier.height(height = 16.dp),
                    rating = 3.5f,
                )
            }
        }

        item { Divider() }

        item {
            Row(
                Modifier
                    .fillMaxSize()
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CAPTION1Text(text = "Price")
                BODY2Text(text = price)
            }
        }

        item { Divider() }

        item {
            Row(
                Modifier
                    .fillMaxSize()
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CAPTION1Text(text = "Created at")
                BODY2Text(text = createdAt)
            }
        }

        item { Divider() }

        item {
            Row(
                Modifier
                    .fillMaxSize()
                    .height(44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CAPTION1Text(text = "Owner ")
                BODY2Text(text = owner)
            }
        }

        item {
            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "Buy - $ 999",
                onClick = { /*TODO*/ }
            )
        }

        item { CAPTION1Text(text = "Description") }

        item { BODY1Text(text = description) }

        item {
            ButtonSecondary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "Add to favorite",
                onClick = { /*TODO*/ },
                leadIcon = Icons.Default.FavoriteBorder
            )
        }

        item { CAPTION1Text(text = "Provenance") }

    }
}

@ExperimentalUnitApi
@Composable
@Preview(showBackground = true, backgroundColor = 0xFF121311, uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
private fun PresentationDashboard_Preview() {
    GallerySpaceTheme {
        PresentationDashboard(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            title = "Cthulhu Mythos.",
            description = "In his essay \"H. P. Lovecraft and the Cthulhu Mythos\", Robert M. Price described two stages in the development of the Cthulhu Mythos. Price called the first stage the \"Cthulhu Mythos proper\". This stage was formulated during Lovecraft's lifetime and was subject to his guidance. The second stage was guided by August Derleth who, in addition to publishing Lovecraft's stories after his death, attempted to categorize and expand the Mythos.",
            creator = "by H. P. Lovecraft",
            price = "0.251 BTC",
            createdAt = "16 May, 22",
            owner = "Olivie Piero"
        )
    }
}