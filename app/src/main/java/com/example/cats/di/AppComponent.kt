package com.example.cats.di

import android.content.Context
import com.example.cats.api.CatsService
import com.example.cats.db.CatDatabase
import com.example.cats.db.CatsRepository
import com.example.cats.db.ShowDao
import com.example.cats.di.modules.AppModule
import com.example.cats.di.modules.RetrofitModule
import com.example.cats.di.modules.RoomModule
import com.example.cats.mvp.presenter.CatsPresenter
import com.example.cats.ui.adapters.CatsAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [AppModule::class, RetrofitModule::class, RoomModule::class])
interface AppComponent {
    var getContext : Context
    var getService : CatsService

    var showDao : ShowDao
    var catDatabase: CatDatabase
    var catRepository: CatsRepository

    fun inject(adapter : CatsAdapter)
    fun inject(presenter : CatsPresenter)

}