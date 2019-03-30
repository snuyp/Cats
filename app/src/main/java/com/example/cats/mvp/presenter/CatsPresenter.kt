package com.example.cats.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.cats.App
import com.example.cats.api.CatsService
import com.example.cats.mvp.view.CatsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

@InjectViewState
class CatsPresenter : MvpPresenter<CatsView>() {

    private var service = App.component.getService

    private lateinit var disposable: Disposable

    override fun onFirstViewAttach() {
        App.component.inject(this)
        getCats(limit = 10,page = 1)
        super.onFirstViewAttach()
    }

    private fun getCats(limit :Int, page : Int) {
        disposable = service.getCats(limit,page,CatsService.KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> viewState.showCats(result) },
                { error -> viewState.error(error.toString()) }
            )

    }
    fun dispose() = disposable.dispose()
}