package com.voitenko.dev.galleryspace.db

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime

val listOfStringsAdapter = object : ColumnAdapter<List<String>, String> {
    override fun decode(databaseValue: String) =
        if (databaseValue.isEmpty()) {
            listOf()
        } else {
            databaseValue.split(",")
        }

    override fun encode(value: List<String>) = value.joinToString(separator = ",")
}

val dateAdapter = object : ColumnAdapter<LocalDateTime, String> {

    override fun decode(databaseValue: String): LocalDateTime =
        databaseValue.toLocalDateTime()

    override fun encode(value: LocalDateTime): String =
        value.toString()
}