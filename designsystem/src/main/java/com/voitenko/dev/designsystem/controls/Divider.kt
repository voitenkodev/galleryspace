package com.voitenko.dev.designsystem.controls

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voitenko.dev.designsystem.GallerySpaceComponent

@Composable
fun Divider(modifier: Modifier = Modifier) = androidx.compose.material.Divider(
    modifier = modifier, color = GallerySpaceComponent.colors.secondary.copy(alpha = 0.1f)
)