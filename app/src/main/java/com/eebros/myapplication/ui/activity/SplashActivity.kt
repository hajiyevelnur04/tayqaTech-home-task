package com.eebros.myapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.eebros.myapplication.data.local.ErrorMessageMapper
import com.eebros.myapplication.R
import com.eebros.myapplication.base.BaseActivity
import com.eebros.myapplication.di.ViewModelProviderFactory
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: SplashActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProvider(this, factory)[SplashActivityViewModel::class.java]

        //add all static mapper before app start
        ErrorMessageMapper().saveDataToMap()

        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}
