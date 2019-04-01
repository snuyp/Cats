package com.example.cats.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.cats.App
import com.example.cats.db.CatsRepository
import com.example.cats.mvp.view.FavoritesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class RepositoryFavoritesPresenter : MvpPresenter<FavoritesView>() {

    lateinit var disposable: Disposable

    @Inject
    lateinit var catsRepository: CatsRepository

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()


    }

    fun loadFavoritesCat() {
        disposable = catsRepository.getAllFavoriteCats()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { viewState.showCats(it) },
                { error -> viewState.error(error.toString()) }
            )
    }

    fun dispose() {
        disposable.dispose()
    }


}