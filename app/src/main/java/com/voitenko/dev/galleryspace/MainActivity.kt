package com.voitenko.dev.galleryspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.core.view.WindowCompat

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalUnitApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            val useDarkIcons = MaterialTheme.colors.isLight

//            GallerySpaceTheme {
//                val systemUiController = rememberSystemUiController()
//                val navController = rememberAnimatedNavController()
//                SideEffect {
//                    systemUiController.setSystemBarsColor(
//                        color = Color.Transparent,
//                        darkIcons = false
//                    )
//                }
//
//                Surface(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                        .navigationBarsPadding(),
//                    color = GallerySpaceComponent.colors.primary,
//                    content = { NavigationComponent(navController = navController) }
//                )
//            }
        }
    }
}