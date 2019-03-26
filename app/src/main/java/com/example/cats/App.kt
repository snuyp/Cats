package com.example.cats

import android.app.Application
import com.example.cats.di.AppComponent
import com.example.cats.di.DaggerAppComponent
import com.example.cats.di.modules.AppModule
import com.example.cats.di.modules.RetrofitModule

class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }
}