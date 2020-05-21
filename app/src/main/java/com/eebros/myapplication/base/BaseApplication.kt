package com.eebros.myapplication.base

import androidx.room.Room
import com.eebros.myapplication.di.DaggerAppComponent
import com.eebros.myapplication.room.BaseRateDao
import com.eebros.myapplication.room.BaseRateDatabase
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.plugins.RxJavaPlugins
import javax.inject.Inject

class BaseApplication : DaggerApplication(), HasAndroidInjector  {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    /*lateinit var dao: BaseRateDao*/

    override fun androidInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {
            it.printStackTrace()
        }

       /* dao = Room.databaseBuilder(this, BaseRateDatabase::class.java, "baseRate")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
            .baseRateDao()*/

    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}