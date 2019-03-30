package com.example.cats.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.cats.db.CatsRepository
import com.example.cats.mvp.model.Cats
import com.example.cats.mvp.view.FavoritesView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class RepositoryFavoritesPresenter : MvpPresenter<FavoritesView>() {

    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var catsRepository: CatsRepository

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    fun addToFavorite(cat: Cats) {
        catsRepository.insertCatsIntoFavorites(cat)
    }

}