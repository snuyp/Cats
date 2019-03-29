package com.example.cats.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [FavoriteCats::class], version = 1, exportSchema = false)
abstract class CatDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "cats.db"
    }

    abstract fun showDao() : ShowDao
}