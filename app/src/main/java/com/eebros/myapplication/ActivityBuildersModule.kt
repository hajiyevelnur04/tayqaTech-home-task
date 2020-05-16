package com.eebros.myapplication

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