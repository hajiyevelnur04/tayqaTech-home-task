package com.eebros.myapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eebros.myapplication.R
import com.eebros.myapplication.base.BaseFragment
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import com.eebros.myapplication.di.ViewModelProviderFactory
import com.eebros.myapplication.util.AlertDialogMapper
import com.eebros.myapplication.util.TayqaAnimation
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_cash_convert.*
import javax.inject.Inject

class CashConvertFragment : BaseFragment() {
    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: CashConvertFragmentViewModel

    lateinit var adapter : CashConvertFragmentAdapter

    private val currencies = arrayListOf<GetBaseConvertResponse>()

    lateinit var progress: ImageView

    lateinit var failText: TextView

    lateinit var currencyContainer: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_cash_convert, container, false)

        viewModel = ViewModelProvider(this, factory)[CashConvertFragmentViewModel::class.java]

        initView(view)

        //start rotating progress image
        TayqaAnimation.animateProgressImage(currencyContainer,progress)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        currencyContainer.layoutManager = llm

        adapter = CashConvertFragmentAdapter(context, currencies){
            //implement item onclick listener
        }
        currencyContainer.adapter = adapter

        setOutputListener()
        setInputListener()

        return view
    }

    private fun initView(view: View){
        progress = view.findViewById(R.id.progress)
        failText = view.findViewById(R.id.failMessage)
        currencyContainer = view.findViewById(R.id.currencyContainer)
    }

    private fun setInputListener() {
        viewModel.inputs.getBaseConvert("EUR")
    }

    private fun setOutputListener() {
        viewModel.outputs.onBaseConvertSuccess().subscribe{
            Log.d("response", it[0].toString())
            currencies.clear()
            currencies.addAll(it)
            adapter.notifyDataSetChanged()

            progress.clearAnimation()
            progress.visibility = View.GONE
            currencyContainer.visibility = View.VISIBLE

        }.addTo(subscriptions)

        viewModel.onError().subscribe {
            // it is iteration int value and should return from server
            AlertDialogMapper(requireActivity(), it).showAlertDialog()
        }.addTo(subscriptions)
    }
}
