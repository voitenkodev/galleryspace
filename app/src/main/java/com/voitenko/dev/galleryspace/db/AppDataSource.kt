package com.voitenko.dev.galleryspace.db

import android.content.Context
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDateTime

class AppDataSource(context: Context) {

    private val database: AppDataBaseQueries = database(DatabaseDriverFactory(context = context).createDriver())

    private fun lastId(): Flow<Long?> =
        database.getLastId().asFlow().map { it.executeAsOneOrNull() }

    fun setArt(
        url: String,
        title: String,
        description: String,
        price: String,
        createdAt: LocalDateTime,
        proprietors: List<String>
    ): Flow<Long?> = flowOf(database.setArt(url, title, description, price, createdAt, proprietors))
        .flatMapConcat { lastId() }

    fun updateArt(
        id: Long,
        url: String,
        title: String,
        description: String,
        price: String,
        createdAt: LocalDateTime,
        proprietors: List<String>
    ): Flow<Long?> = flowOf(database.updateArt(id, url, title, description, price, createdAt, proprietors))
        .flatMapConcat { lastId() }

    fun getArt(
        id: Long,
    ): Flow<Art?> = flowOf(database.getArtById(id)).map { it.executeAsOneOrNull() }

    fun getArts(): Flow<List<Art>> = flowOf(database.getArts()).map { it.executeAsList() }

}
