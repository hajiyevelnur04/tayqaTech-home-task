package com.eebros.myapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.eebros.myapplication.di.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}