package com.example.cats.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.example.cats.db.CatDatabase
import com.example.cats.db.ShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideTvMazeDatabase(context: Context): CatDatabase {
        return Room.databaseBuilder(context,
            CatDatabase::class.java, CatDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideShowDao(catDatabase: CatDatabase): ShowDao {
        return catDatabase.showDao()
    }
}