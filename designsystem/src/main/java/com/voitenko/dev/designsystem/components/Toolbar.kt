package com.voitenko.dev.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.voitenko.dev.designsystem.common.third
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
        Icon(
            modifier = Modifier
                .size(44.dp)
                .padding(8.dp),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = third
        )

        H2Text(
            modifier = Modifier.weight(1f),
            text = "Gallery\nSpace",
            textAlign = TextAlign.Center
        )

        Icon(
            modifier = Modifier
                .size(44.dp)
                .padding(8.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            tint = third
        )
    }
}