package com.voitenko.dev.designsystem.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voitenko.dev.designsystem.common.fourth
import com.voitenko.dev.designsystem.common.sixteen
import com.voitenko.dev.designsystem.common.brown
import com.voitenko.dev.designsystem.common.white
import com.voitenko.dev.designsystem.controls.BODY2Text
import com.voitenko.dev.designsystem.controls.CAPTIONText
import com.voitenko.dev.designsystem.controls.RatingBar

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
                    colorEnabled = brown,
                    colorDisabled = fourth
                )
            }

            Field(caption = "Price:") {
                BODY2Text(
                    text = "200$",
                    color = sixteen,
                )
            }

            Field(caption = "Created at:") {
                BODY2Text(
                    text = "16 May, 22",
                    color = white,
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
private fun Field(modifier: Modifier = Modifier, caption: String, value: @Composable () -> Unit) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CAPTIONText(text = caption)
        value.invoke()
    }
}