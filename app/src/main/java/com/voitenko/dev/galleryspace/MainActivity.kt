package com.voitenko.dev.galleryspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.voitenko.dev.designsystem.common.GallerySpaceTheme
import com.voitenko.dev.galleryspace.presentation.PresentPictureScreen

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalUnitApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            GallerySpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
//                    Box(modifier = Modifier.fillMaxSize()) {
//                        Spacer(
//                            modifier = Modifier
//                                .accelerate().size(100.dp)
//                                .background(Color.Magenta)
//
//                        )
//                    }
//                    GalleryScreen()
                    PresentPictureScreen()
                }
            }
        }
    }
}