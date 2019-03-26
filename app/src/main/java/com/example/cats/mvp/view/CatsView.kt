package com.example.cats.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.cats.mvp.model.Cats


@StateStrategyType(AddToEndSingleStrategy::class)
interface CatsView : MvpView {
    fun showCats(rates : List<Cats>)
    fun error(message : String)
}