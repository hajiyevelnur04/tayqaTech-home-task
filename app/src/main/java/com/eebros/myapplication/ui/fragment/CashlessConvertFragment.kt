package com.eebros.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eebros.myapplication.R
import com.eebros.myapplication.base.BaseFragment
import com.eebros.myapplication.di.ViewModelProviderFactory
import javax.inject.Inject

class CashlessConvertFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: CashlessConvertFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_cash_convert, container, false)

        viewModel = ViewModelProvider(this, factory)[CashlessConvertFragmentViewModel::class.java]
        return view
    }
}
