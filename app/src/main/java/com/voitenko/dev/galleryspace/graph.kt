package com.voitenko.dev.galleryspace

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.voitenko.dev.galleryspace.gallery.GalleryScreen
import com.voitenko.dev.galleryspace.presentation.PresentationScreen

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Gallery.route
    ) {

        composable(route = Routes.Gallery.route) {
            GalleryScreen { art ->
                navController.navigate("${Routes.Presentation.route}/${art.id}")
            }
        }

        composable(
            route = "${Routes.Presentation.route}/{artId}",
            arguments = listOf(
                navArgument("artId") { type = NavType.StringType }
            )
        ) {
            it.arguments?.getString("artId")?.let { artId ->
                PresentationScreen(artId)
            }
        }
    }
}

sealed class Routes(val route: String) {
    object Gallery : Routes("gallery_screen")
    object Presentation : Routes("presentation_screen")
}