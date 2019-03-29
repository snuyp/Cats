package com.example.cats.db;

import android.arch.persistence.room.*;
import io.reactivex.Single;

import java.util.List;

@Dao
public interface ShowDao {
    @Query("SELECT * FROM favorite_cats")
    Single<List<FavoriteCats>> getAllFavoriteCats();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FavoriteCats favoriteCats);

    @Delete
    void remove(FavoriteCats favoriteCats);

    @Query("SELECT count(*) FROM favorite_cats where id LIKE :id")
    int isFavouriteCats(long id);
}
