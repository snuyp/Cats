package com.example.cats.db

import com.example.cats.mvp.model.Cats
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatsRepository @Inject constructor(var showDao: ShowDao) {

    fun getAllFavoriteCats(): Single<List<FavoriteCats>> {
        return showDao.allFavoriteCats
    }

    fun isFavoriteShow(id: Long): Boolean {
        return showDao.isFavouriteCats(id) > 0
    }

    fun insertCatsIntoFavorites(cat: Cats) {
        val favoriteCat = FavoriteCats().apply {
            id = cat.id
            url = cat.url
        }
        showDao.insert(favoriteCat)
    }

    fun removeCatsFromFavorites(cat: Cats) {
        val favoriteCats = FavoriteCats().apply {
            id = cat.id
            url = cat.url
        }
        showDao.remove(favoriteCats)
    }

    fun insertIntoFavorites(favoriteCats: FavoriteCats) {
        showDao.insert(favoriteCats)
    }

    fun removeFromFavorites(favoriteCats: FavoriteCats) {
        showDao.remove(favoriteCats)
    }
}