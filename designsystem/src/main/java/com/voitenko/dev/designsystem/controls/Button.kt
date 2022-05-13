package com.voitenko.dev.designsystem.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.common.white

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier,
        text = text,
        textStyle = GallerySpaceComponent.typography.BUTTON1,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
private fun Button(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    TextButton(
        modifier = Modifier
            .wrapContentSize()
            .then(modifier),
        onClick = onClick,
        content = {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                text = text.uppercase(),
                textStyle = textStyle
            )
        },
        enabled = enabled,
        shape = RoundedCornerShape(50),
        border = BorderStroke(2.dp, white)
    )
}