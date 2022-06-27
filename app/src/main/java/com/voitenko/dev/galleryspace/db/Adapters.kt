package com.voitenko.dev.galleryspace.db

import com.squareup.sqldelight.ColumnAdapter

val listOfStringsAdapter = object : ColumnAdapter<List<String>, String> {
    override fun decode(databaseValue: String) =
        if (databaseValue.isEmpty()) {
            listOf()
        } else {
            databaseValue.split(",")
        }
    override fun encode(value: List<String>) = value.joinToString(separator = ",")
}

//val queryWrapper: AppDa = AppDataBase(
//    driver = driver,
//    hockeyPlayerAdapter = hockeyPlayer.Adapter(
//        cup_winsAdapter = listOfStringsAdapter
//    )
//)
