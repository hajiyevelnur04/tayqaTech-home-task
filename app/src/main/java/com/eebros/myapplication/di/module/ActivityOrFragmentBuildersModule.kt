package com.eebros.myapplication.di.module

import com.eebros.myapplication.di.module.sub.ExchangeModule
import com.eebros.myapplication.di.module.sub.MainModule
import com.eebros.myapplication.di.module.viewmodel.ExchangeViewModelModule
import com.eebros.myapplication.di.module.viewmodel.MainViewModelModule
import com.eebros.myapplication.di.scope.ExchangeScope
import com.eebros.myapplication.di.scope.MainScope
import com.eebros.myapplication.ui.activity.MainActivity
import com.eebros.myapplication.ui.activity.SplashActivity
import com.eebros.myapplication.ui.fragment.CashConvertFragment
import com.eebros.myapplication.ui.fragment.CashlessConvertFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityOrFragmentBuildersModule {

    @MainScope
    @ContributesAndroidInjector (modules = [MainModule::class, MainViewModelModule::class])
    abstract fun splashActivity(): SplashActivity

    @MainScope
    @ContributesAndroidInjector (modules = [MainModule::class, MainViewModelModule::class])
    abstract fun mainActivity(): MainActivity

    @ExchangeScope
    @ContributesAndroidInjector (modules = [ExchangeViewModelModule::class])
    abstract fun cashConvertFragment(): CashConvertFragment

    @ExchangeScope
    @ContributesAndroidInjector (modules = [ExchangeViewModelModule::class])
    abstract fun cashlessConvertFragment(): CashlessConvertFragment

}