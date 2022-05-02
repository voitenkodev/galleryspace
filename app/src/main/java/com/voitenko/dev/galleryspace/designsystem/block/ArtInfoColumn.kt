package com.voitenko.dev.galleryspace.designsystem.block

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voitenko.dev.galleryspace.designsystem.components.BODY2Text
import com.voitenko.dev.galleryspace.designsystem.components.CAPTIONText
import com.voitenko.dev.galleryspace.designsystem.components.RatingBar
import com.voitenko.dev.galleryspace.designsystem.fourth
import com.voitenko.dev.galleryspace.designsystem.sixteen
import com.voitenko.dev.galleryspace.designsystem.third
import com.voitenko.dev.galleryspace.designsystem.white

@Composable
fun ArtInfoColumn(modifier: Modifier = Modifier, visibility: Boolean) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visibility,
        enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
        exit = shrinkHorizontally() + fadeOut()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start
        ) {

            Field(caption = "Rating:") {
                RatingBar(
                    modifier = Modifier.height(height = 16.dp),
                    rating = 3.2f,
                    colorEnabled = third,
                    colorDisabled = fourth
                )
            }

            Field(caption = "Created at:") {
                BODY2Text(
                    text = "16 May, 22",
                    color = white,
                )
            }

            Field(caption = "Price:") {
                BODY2Text(
                    text = "200$",
                    color = sixteen,
                )
            }

            Field(caption = "Sign:") {
                BODY2Text(
                    text = "by Maxim"
                )
            }
        }
    }
}

@Composable
private fun Field(caption: String, value: @Composable () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CAPTIONText(text = caption)
        value.invoke()
    }

}