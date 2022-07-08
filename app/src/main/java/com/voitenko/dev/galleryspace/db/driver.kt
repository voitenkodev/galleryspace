package com.voitenko.dev.galleryspace.db

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver


internal fun database(driver: SqlDriver): AppDataBaseQueries = AppDataBase.invoke(
    driver,
    Art.Adapter(dateAdapter, listOfStringsAdapter),
).appDataBaseQueries


internal class DatabaseDriverFactory(private val context: Context) {
    internal fun createDriver(): SqlDriver = AndroidSqliteDriver(
        AppDataBase.Schema,
        context,
        "GallerySpace.db",
        callback = object : AndroidSqliteDriver.Callback(AppDataBase.Schema) {
            override fun onConfigure(db: SupportSQLiteDatabase) {
                super.onConfigure(db)
                db.setForeignKeyConstraintsEnabled(true)
            }
        }
    )
}
