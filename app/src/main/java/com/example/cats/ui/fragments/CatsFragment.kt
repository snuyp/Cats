package com.example.cats.ui.fragments

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.cats.R
import com.example.cats.mvp.model.Cats
import com.example.cats.mvp.presenter.CatsPresenter
import com.example.cats.mvp.view.CatsView
import com.example.cats.ui.adapters.CatsAdapter
import kotlinx.android.synthetic.main.fragment_cats.*
import javax.inject.Inject

class CatsFragment : MvpAppCompatFragment(), CatsView {

    @Inject
    @InjectPresenter
    internal lateinit var catsPresenter : CatsPresenter

    internal lateinit var swipeRefreshLayout: SwipeRefreshLayout

    companion object {
        fun newInstance(): CatsFragment {
            return  CatsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_cats,container,false)
        swipeRefreshLayout = v.findViewById(R.id.swipe_refresh)

        swipeRefreshLayout.setOnRefreshListener { catsPresenter.getCats(10,++catsPresenter.page, true)}
        return v
    }
    override fun showCats(cats : ArrayList<Cats>) {
        lst_cats.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = CatsAdapter(cats)
        }
    }
    override fun setRefresh(isRefreshing: Boolean) {
        swipeRefreshLayout.isRefreshing = isRefreshing
    }


    override fun error(message: String) {
        Log.e("Error",message)
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        catsPresenter.dispose()
    }
}