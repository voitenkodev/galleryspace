package com.voitenko.dev.galleryspace

import com.voitenko.dev.galleryspace.db.AppDataSource
import com.voitenko.dev.galleryspace.db.AppDataSourceImpl
import com.voitenko.dev.galleryspace.gallery.GalleryViewModel
import com.voitenko.dev.galleryspace.newart.NewArtViewModel
import com.voitenko.dev.galleryspace.presentation.PresentationViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single(named("IO")) { Dispatchers.IO }
    single(named("MAIN")) { Dispatchers.Main }
    single { AppDataSourceImpl(get(), get(named("IO"))) } bind AppDataSource::class
    singleOf(::ImageSaver)

    viewModelOf(::NewArtViewModel)
    viewModelOf(::GalleryViewModel)
    viewModelOf(::PresentationViewModel)
}