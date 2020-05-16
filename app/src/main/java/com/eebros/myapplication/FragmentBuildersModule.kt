package com.eebros.myapplication

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @MainScope
    @ContributesAndroidInjector (modules = [MainModule::class, MainViewModelModule::class])
    abstract fun cashConvertFragment(): CashConvertFragment

    @MainScope
    @ContributesAndroidInjector (modules = [MainModule::class, MainViewModelModule::class])
    abstract fun cashlessConvertFragment(): CashlessConvertFragment

}