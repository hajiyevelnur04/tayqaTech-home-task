package com.eebros.myapplication.di.module

import com.eebros.myapplication.di.module.sub.MainModule
import com.eebros.myapplication.di.module.viewmodel.MainViewModelModule
import com.eebros.myapplication.di.scope.MainScope
import com.eebros.myapplication.ui.activity.MainActivity
import com.eebros.myapplication.ui.activity.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector (modules = [MainModule::class, MainViewModelModule::class])
    abstract fun splashActivity(): SplashActivity

    @MainScope
    @ContributesAndroidInjector (modules = [MainModule::class, MainViewModelModule::class])
    abstract fun mainActivity(): MainActivity

}