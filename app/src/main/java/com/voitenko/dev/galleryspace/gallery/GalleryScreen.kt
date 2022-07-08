package com.voitenko.dev.galleryspace.gallery

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.components.PresentationItem
import com.voitenko.dev.designsystem.components.Toolbar
import com.voitenko.dev.galleryspace.Routes
import com.voitenko.dev.galleryspace.mock

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun GalleryScreen(navController: NavController) {

    val arts = mock()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        stickyHeader {
            Toolbar(modifier = Modifier.statusBarsPadding())
        }

        itemsIndexed(arts) { index, item ->
            PresentationItem(
                url = item.url,
                title = item.title,
                description = item.description,
                creator = item.creator,
                more = {
                    navController.navigate("${Routes.Presentation.route}/${item.id}")
                }
            )
        }
    }
}
