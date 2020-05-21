package com.eebros.myapplication.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.eebros.myapplication.di.scope.ViewModelKey
import com.eebros.myapplication.ui.fragment.ConvertFragmentViewModel
import com.eebros.myapplication.ui.fragment.ExchangeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ExchangeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExchangeFragmentViewModel::class)
    abstract fun bindExchangeFragmentViewModel(viewModel: ExchangeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ConvertFragmentViewModel::class)
    abstract fun bindConvertFragmentViewModel(viewModel: ConvertFragmentViewModel): ViewModel

}