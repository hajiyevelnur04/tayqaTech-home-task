package com.eebros.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tayqa_toolbar_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = MainActivityAdapter(
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
