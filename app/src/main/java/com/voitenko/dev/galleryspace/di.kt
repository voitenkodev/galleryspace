package com.voitenko.dev.galleryspace

import com.voitenko.dev.galleryspace.db.AppDataSource
import com.voitenko.dev.galleryspace.newart.NewArtViewModel
import com.voitenko.dev.galleryspace.gallery.GalleryViewModel
import com.voitenko.dev.galleryspace.presentation.PresentationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::AppDataSource)

    viewModelOf(::NewArtViewModel)
    viewModelOf(::GalleryViewModel)
    viewModelOf(::PresentationViewModel)
}