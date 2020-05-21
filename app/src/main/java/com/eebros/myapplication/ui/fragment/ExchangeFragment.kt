package com.eebros.myapplication.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.eebros.myapplication.R
import com.eebros.myapplication.base.BaseFragment
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import com.eebros.myapplication.di.ViewModelProviderFactory
import com.eebros.myapplication.util.AlertDialogMapper
import com.eebros.myapplication.util.TayqaAnimation
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.exchange_item.*
import javax.inject.Inject


class ExchangeFragment : BaseFragment() {
    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: ExchangeFragmentViewModel

    lateinit var adapter : ExchangeFragmentAdapter

    private val currencies = arrayListOf<GetBaseConvertResponse>()

    lateinit var progress: ImageView

    lateinit var failText: TextView

    lateinit var currencyContainer: RecyclerView

    var defaultBaseRate = "EUR"

    var isSelected = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_exchange, container, false)

        viewModel = ViewModelProvider(this, factory)[ExchangeFragmentViewModel::class.java]

        initView(view)

        //start rotating progress image
        currencyContainer.visibility = View.GONE
        TayqaAnimation.animateProgressImage(currencyContainer,progress)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        currencyContainer.layoutManager = llm

        adapter = ExchangeFragmentAdapter(context, currencies){ it ->

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
        viewModel.inputs.getBaseConvert(defaultBaseRate)

    }

    private fun setOutputListener() {
        viewModel.outputs.onBaseConvertSuccess().subscribe{
            Log.d("response", it[0].toString())
            Toast.makeText(context, "Online",Toast.LENGTH_SHORT).show()

            currencies.clear()
            currencies.addAll(it)
            adapter.notifyDataSetChanged()

            progress.clearAnimation()
            progress.visibility = View.GONE
            currencyContainer.visibility = View.VISIBLE

        }.addTo(subscriptions)

        viewModel.outputs.onChangeBaseValue().subscribe{inputValue->
            /*currencies.forEach{
                it.inverseRate = inputValue * it.inverseRate
                adapter.notifyDataSetChanged()
            }*/
        }.addTo(subscriptions)

        viewModel.onError().subscribe {
            // it is iteration int value and should return from server
            //AlertDialogMapper(requireActivity(), it).showAlertDialog()
            progress.clearAnimation()
            progress.visibility = View.GONE
            Toast.makeText(context, "Offline",Toast.LENGTH_SHORT).show()
        }.addTo(subscriptions)
    }
}
