package com.example.cats.db

import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface ShowDao {
    @Query("SELECT * FROM favorite_cats")
    fun allFavoriteCats(): Flowable<List<FavoriteCats>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoriteCats: FavoriteCats)

    @Delete
    fun remove(favoriteCats: FavoriteCats)

    @Query("SELECT count(*) FROM favorite_cats where id LIKE :id")
    fun isFavouriteCats(id: Long): Int
}

