package com.example.cats.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.cats.mvp.model.Cats
import com.example.cats.mvp.presenter.CatsPresenter
import com.example.cats.mvp.view.CatsView
import javax.inject.Inject

class CatsFragment : MvpAppCompatFragment(), CatsView {

    @Inject
    @InjectPresenter
    internal lateinit var ratesPresenter : CatsPresenter

    companion object {
        fun newInstance(): CatsFragment {
            return  CatsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun showCats(rates: List<Cats>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun error(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}