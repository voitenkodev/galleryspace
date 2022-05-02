package com.voitenko.dev.galleryspace.designsystem.block

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voitenko.dev.galleryspace.designsystem.third

@Composable
fun Toolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier
                .size(44.dp)
                .padding(8.dp),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = third
        )

        Icon(
            modifier = Modifier
                .size(44.dp)
                .padding(8.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = "",
            tint = third
        )
    }
}