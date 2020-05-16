package com.eebros.myapplication.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.eebros.myapplication.di.scope.ViewModelKey
import com.eebros.myapplication.ui.fragment.CashConvertFragmentViewModel
import com.eebros.myapplication.ui.fragment.CashlessConvertFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ExchangeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CashConvertFragmentViewModel::class)
    abstract fun bindCashConvertFragmentViewModel(viewModel: CashConvertFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CashlessConvertFragmentViewModel::class)
    abstract fun bindCashlessConvertFragmentViewModel(viewModel: CashlessConvertFragmentViewModel): ViewModel

}