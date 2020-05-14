package com.eebros.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //add all static mapper before app start
        ErrorMessageMapper().saveDataToMap()

        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}
