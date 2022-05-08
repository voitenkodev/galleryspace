package com.voitenko.dev.designsystem.block

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voitenko.dev.designsystem.components.BODY2Text
import com.voitenko.dev.designsystem.components.CAPTIONText
import com.voitenko.dev.designsystem.components.RatingBar
import com.voitenko.dev.designsystem.fourth
import com.voitenko.dev.designsystem.sixteen
import com.voitenko.dev.designsystem.third
import com.voitenko.dev.designsystem.white

@Composable
fun ArtInfoRow(modifier: Modifier = Modifier, visibility: Boolean) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visibility,
        enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
        exit = shrinkHorizontally() + fadeOut()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Field(
                modifier = Modifier.weight(1f),
                caption = "Rating"
            ) {
                RatingBar(
                    modifier = Modifier.height(height = 16.dp),
                    rating = 3.2f,
                    colorEnabled = third,
                    colorDisabled = fourth
                )
            }

            Field(
                modifier = Modifier.weight(1f),
                caption = "Price"
            ) {
                BODY2Text(
                    text = "1999$",
                    color = sixteen,
                )
            }

            Field(
                modifier = Modifier.weight(1f),
                caption = "Created at"
            ) {
                BODY2Text(
                    text = "16 May, 22",
                    color = white,
                )
            }
        }
    }
}

@Composable
private fun Field(modifier: Modifier = Modifier, caption: String, value: @Composable () -> Unit) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        value.invoke()

        CAPTIONText(
            text = caption
        )
    }

}