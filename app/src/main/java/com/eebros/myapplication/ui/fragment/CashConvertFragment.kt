package com.eebros.myapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.eebros.myapplication.R
import com.eebros.myapplication.base.BaseFragment
import com.eebros.myapplication.di.ViewModelProviderFactory
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class CashConvertFragment : BaseFragment() {
    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: CashConvertFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_cashless_convert, container, false)

        viewModel = ViewModelProvider(this, factory)[CashConvertFragmentViewModel::class.java]

        setOutputListener()
        setInputListener()

        return view
    }

    private fun setInputListener() {
        viewModel.inputs.getBaseConvert("EUR")
    }

    private fun setOutputListener() {
        viewModel.outputs.onBaseConvertSuccess().subscribe{
            Log.d("response", it[0].toString())
        }.addTo(subscriptions)
    }
}
