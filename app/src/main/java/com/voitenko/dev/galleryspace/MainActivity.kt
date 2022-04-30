package com.voitenko.dev.galleryspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.voitenko.dev.galleryspace.designsystem.GallerySpaceTheme
import com.voitenko.dev.galleryspace.designsystem.crystal
import com.voitenko.dev.galleryspace.presentpicture.PresentPictureScreen

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalUnitApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val systemUiController = rememberSystemUiController()
//            val useDarkIcons = MaterialTheme.colors.isLight
//
//            SideEffect {
//                systemUiController.setSystemBarsColor(
//                    color = Color.Black,
//                    darkIcons = useDarkIcons
//                )
//                // setStatusBarsColor()
//                // setNavigationBarColor()
//            }

            GallerySpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = crystal
                ) {
                    PresentPictureScreen()
                }
            }
        }
    }
}