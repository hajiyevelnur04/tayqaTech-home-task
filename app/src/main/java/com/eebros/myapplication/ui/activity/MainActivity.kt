package com.eebros.myapplication.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.eebros.myapplication.R
import com.eebros.myapplication.base.BaseActivity
import com.eebros.myapplication.di.ViewModelProviderFactory
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tayqa_toolbar_layout.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, factory)[MainActivityViewModel::class.java]

        val sectionsPagerAdapter =
            MainActivityAdapter(
                this,
                supportFragmentManager
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)

        toolbar_title.text = getString(R.string.main)
        toolbar_back_button.setOnClickListener { onBackPressed() }
        tabs.setupWithViewPager(viewPager)
    }
}
