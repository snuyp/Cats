package com.example.cats.di

import android.content.Context
import com.example.cats.api.CatsService
import com.example.cats.db.CatDatabase
import com.example.cats.di.modules.AppModule
import com.example.cats.di.modules.DbModule
import com.example.cats.di.modules.RetrofitModule
import com.example.cats.mvp.presenter.CatsPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [AppModule::class, RetrofitModule::class, DbModule::class])
interface AppComponent {
    var getContext : Context
    var getService : CatsService

    fun inject(presenter : CatsPresenter)


}