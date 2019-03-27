package com.example.cats.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.cats.R
import com.example.cats.ui.adapters.FragmentAdapter
import android.support.v4.view.ViewPager

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val adapter = FragmentAdapter(supportFragmentManager, this)
        viewPager.adapter = adapter

        val mTabLayout = findViewById<TabLayout>(R.id.tabLayout)
        mTabLayout.setupWithViewPager(viewPager)
    }
}
