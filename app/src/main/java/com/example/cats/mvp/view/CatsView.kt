package com.example.cats.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.cats.mvp.model.Cats


@StateStrategyType(AddToEndSingleStrategy::class)
interface CatsView : MvpView {
    fun showCats(cats : ArrayList<Cats>)
    fun error(message : String)
    fun setRefresh(isRefreshing: Boolean)
}