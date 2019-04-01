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

    var page = 1

    override fun onFirstViewAttach() {
        App.component.inject(this)
        getCats(limit = 10,page = page,isUpdate = false)
        super.onFirstViewAttach()
    }

    fun getCats(limit :Int, page : Int, isUpdate : Boolean) {
        if(!isUpdate) {
            disposable = getNewCats(limit,page)
        } else {
            disposable = getNewCats(limit,page)
            viewState.setRefresh(false)
        }
    }
    private fun getNewCats(limit :Int, page : Int) = service.getCats(limit, page, CatsService.KEY)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(
            { viewState.showCats(it)},
            { error -> viewState.error(error.toString())}
        )

    fun dispose() = disposable.dispose()
}