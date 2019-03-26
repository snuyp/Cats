package com.example.cats.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.cats.mvp.presenter.CatsPresenter
import javax.inject.Inject

class FavoriteCats : MvpAppCompatFragment()  {


    companion object {
        fun newInstance(): FavoriteCats {
            return  FavoriteCats()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}