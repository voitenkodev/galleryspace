package com.voitenko.dev.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.R
import com.voitenko.dev.designsystem.controls.H2Text

@Composable
fun Toolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Dot {

        }

//        H2Text(
//            modifier = Modifier.weight(1f),
//            text = "Gallery\nSpace",
//            textAlign = TextAlign.Center
//        )

        Spacer(modifier = Modifier.weight(1f),)

        Menu {

        }
    }
}

@Composable
fun Dot(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Spacer(
        modifier = modifier
            .size(44.dp)
            .clip(shape = RoundedCornerShape(50))
            .clickable { onClick.invoke() }
            .padding(16.dp)
            .background(shape = RoundedCornerShape(50), color = GallerySpaceComponent.colors.secondaryControl),
    )
}

@Composable
fun Menu(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Icon(
        painter = painterResource(id = R.drawable.ic_menu),
        modifier = modifier
            .size(44.dp)
            .clip(shape = RoundedCornerShape(50))
            .clickable { onClick.invoke() }
            .padding(8.dp),
        contentDescription = null,
        tint = GallerySpaceComponent.colors.secondaryControl
    )
}