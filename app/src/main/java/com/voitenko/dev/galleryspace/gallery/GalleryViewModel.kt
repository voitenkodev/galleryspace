package com.voitenko.dev.galleryspace.gallery

import androidx.lifecycle.ViewModel
import com.voitenko.dev.galleryspace.db.AppDataSource

class GalleryViewModel(private val source: AppDataSource) : ViewModel() {

    val listOfArts = source.getArts()

}