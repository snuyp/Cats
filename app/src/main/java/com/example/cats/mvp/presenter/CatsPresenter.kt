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

    lateinit var disposable: Disposable

    override fun onFirstViewAttach() {
        App.component.inject(this)
        getCats()
        super.onFirstViewAttach()
    }

    private fun getCats() {
        disposable = service.getCats(10,1,CatsService.KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> viewState.showCats(result) },
                { error -> viewState.error(error.toString()) }
            )
    }
    fun dispose() = disposable.dispose()
}