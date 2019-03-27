package com.example.cats.ui.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.cats.R
import com.example.cats.ui.fragments.CatsFragment
import com.example.cats.ui.fragments.FavoriteCats

class FragmentAdapter (fm: FragmentManager?, var context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CatsFragment.newInstance()
            1 -> FavoriteCats.newInstance()
            else -> CatsFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when (position)
        {
            0 -> context.getString(R.string.cats)
            1 -> context.getString(R.string.favourite_cats)
            else -> context.getString(R.string.not_found)
        }
    }
}