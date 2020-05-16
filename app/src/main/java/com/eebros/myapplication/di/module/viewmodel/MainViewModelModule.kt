package com.eebros.myapplication.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.eebros.myapplication.ui.activity.MainActivityViewModel
import com.eebros.myapplication.ui.activity.SplashActivityViewModel
import com.eebros.myapplication.di.scope.MainScope
import com.eebros.myapplication.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @MainScope
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @MainScope
    @IntoMap
    @ViewModelKey(SplashActivityViewModel::class)
    abstract fun bindSplashActivityViewModel(viewModel: SplashActivityViewModel): ViewModel

}