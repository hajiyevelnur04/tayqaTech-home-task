package com.eebros.myapplication.di.module

import com.eebros.myapplication.di.module.sub.MainModule
import com.eebros.myapplication.di.module.viewmodel.MainViewModelModule
import com.eebros.myapplication.di.scope.MainScope
import com.eebros.myapplication.ui.fragment.CashConvertFragment
import com.eebros.myapplication.ui.fragment.CashlessConvertFragment
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