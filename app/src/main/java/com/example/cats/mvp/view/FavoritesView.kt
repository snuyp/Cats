package com.example.cats.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.cats.db.FavoriteCats
import com.example.cats.mvp.model.Cats


interface FavoritesView : MvpView {
    fun showCats(cats : List<FavoriteCats>)
    fun error(message : String)
}