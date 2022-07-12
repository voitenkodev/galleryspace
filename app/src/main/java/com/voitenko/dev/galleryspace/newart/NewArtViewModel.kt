package com.voitenko.dev.galleryspace.newart

import android.net.Uri
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voitenko.dev.galleryspace.db.AppDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.datetime.LocalDateTime

class NewArtViewModel(private val source: AppDataSource) : ViewModel() {

    data class NewArt(
        val url: Uri = Uri.EMPTY,
        val title: TextFieldValue = TextFieldValue(""),
        val description: TextFieldValue = TextFieldValue(""),
        val price: String = "",
        val createAt: String = "",
    )

    private val _state = MutableStateFlow(NewArt())
    val state: StateFlow<NewArt> = _state

    fun set(
        uri: Uri? = null,
        title: TextFieldValue? = null,
        description: TextFieldValue? = null,
        price: String? = null,
        date: String? = null
    ) {
        _state.value = _state.value.copy(
            url = uri ?: _state.value.url,
            title = title ?: _state.value.title,
            description = description ?: _state.value.description,
            price = price ?: _state.value.price,
            createAt = date ?: _state.value.createAt
        )
    }
    fun save() = source.setArt(
        url = state.value.url.toString(),
        title = state.value.title.text,
        description = state.value.description.text,
        price = state.value.price,
        createdAt = LocalDateTime.parse(state.value.createAt),
        proprietors = emptyList()
    ).launchIn(viewModelScope)
}