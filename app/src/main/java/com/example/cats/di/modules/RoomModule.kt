package com.example.cats.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.example.cats.db.CatDatabase
import com.example.cats.db.CatsRepository
import com.example.cats.db.ShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule (val context: Context) {
    var catDatabase: CatDatabase = Room
        .databaseBuilder(context, CatDatabase::class.java,CatDatabase.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    @Singleton @Provides
    fun provideRoomDatabase() : CatDatabase = catDatabase

    @Singleton @Provides
    fun showDao(catDatabase : CatDatabase): ShowDao = catDatabase.showDao()

    @Singleton @Provides
    fun catRepository(showDao : ShowDao): CatsRepository = CatsRepository(showDao)


}