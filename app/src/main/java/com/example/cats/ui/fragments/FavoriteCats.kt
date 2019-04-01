package com.example.cats.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.cats.App
import com.example.cats.R
import com.example.cats.mvp.presenter.RepositoryFavoritesPresenter
import com.example.cats.mvp.view.FavoritesView
import com.example.cats.ui.adapters.FavoritesAdapter
import kotlinx.android.synthetic.main.fragment_favorite_cats.*
import javax.inject.Inject

class FavoriteCats : MvpAppCompatFragment(), FavoritesView  {

    @Inject
    @InjectPresenter
    lateinit var repositoryPresenter: RepositoryFavoritesPresenter

    companion object {
        fun newInstance(): FavoriteCats {
            return  FavoriteCats()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_favorite_cats,container,false)

        return v
    }

    override fun showCats(cats: List<com.example.cats.db.FavoriteCats>) {
        lst_cats.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = FavoritesAdapter(cats)
        }
        lst_cats.adapter?.notifyDataSetChanged()
    }

    override fun error(message: String) {
        Log.e("Error",message)
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        repositoryPresenter.dispose()

    }
}