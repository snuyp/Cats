package com.example.cats.db

import com.example.cats.mvp.model.Cats
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CatsRepository @Inject constructor(var showDao: ShowDao) {

    fun getAllFavoriteCats(): Single<List<FavoriteCats>> {
        return showDao.allFavoriteCats()
    }

    fun insertCatsIntoFavorites(cat: Cats) {
        val favoriteCat = FavoriteCats().apply {
            url = cat.url
            idS = cat.id
        }
        showDao.insert(favoriteCat)
    }

    fun removeCatsFromFavorites(cat: Cats) {
        val favoriteCats = FavoriteCats().apply {
            url = cat.url
            idS = cat.id
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