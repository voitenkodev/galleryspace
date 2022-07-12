package com.voitenko.dev.galleryspace

import com.voitenko.dev.galleryspace.db.AppDataSource
import com.voitenko.dev.galleryspace.newart.NewArtViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::NewArtViewModel)
    singleOf(::AppDataSource)
}