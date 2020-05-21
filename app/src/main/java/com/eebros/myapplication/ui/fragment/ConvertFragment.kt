package com.eebros.myapplication.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.eebros.myapplication.R
import com.eebros.myapplication.base.BaseFragment
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import com.eebros.myapplication.di.ViewModelProviderFactory
import com.eebros.myapplication.util.TayqaAnimation
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class ConvertFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: ConvertFragmentViewModel

    lateinit var progress: ImageView

    lateinit var failMessage: TextView

    lateinit var mainView: ScrollView

    lateinit var baseConvertRate: AppCompatEditText

    lateinit var currencyName: TextView

    lateinit var rateIcon: ImageView

    lateinit var rateContainer: RecyclerView

    lateinit var adapter : ConvertFragmentAdapter

    private val currencies = arrayListOf<GetBaseConvertResponse>()

    var isSelected = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_convert, container, false)

        initView(view)
        setDefaultValue()

        viewModel = ViewModelProvider(this, factory)[ConvertFragmentViewModel::class.java]

        TayqaAnimation.animateProgressImage(rateContainer, progress)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        rateContainer.layoutManager = llm


        adapter = ConvertFragmentAdapter(context, currencies){ it ->
            //implement item onclick listener
            val drawable: TextDrawable = TextDrawable.builder().buildRect(currencies[it].code, Color.RED)
            isSelected = true
            rateIcon.setImageDrawable(drawable)
            currencyName.text = currencies[it].code
            adapter.notifyDataSetChanged()
        }
        rateContainer.adapter = adapter

        setOutputListener()
        setInputListener()

        return view
    }

    private fun setInputListener() {
        viewModel.inputs.getBaseConvert(currencyName.text.toString())

    }

    private fun setOutputListener() {
        viewModel.outputs.onBaseConvertSuccess().subscribe{
            Log.d("response", it[0].toString())
            currencies.clear()
            currencies.addAll(it)
            adapter.notifyDataSetChanged()

            progress.clearAnimation()
            progress.visibility = View.GONE
            mainView.visibility = View.VISIBLE
            rateContainer.visibility = View.VISIBLE

        }.addTo(subscriptions)

        viewModel.onError().subscribe {
            // it is iteration int value and should return from server
            //AlertDialogMapper(requireActivity(), it).showAlertDialog()
            progress.clearAnimation()
            progress.visibility = View.GONE
            Toast.makeText(context, "last value locally cached", Toast.LENGTH_SHORT).show()
        }.addTo(subscriptions)
    }

    private fun initView(view: View) {
        progress = view.findViewById(R.id.progress)
        failMessage = view.findViewById(R.id.failMessage)
        mainView = view.findViewById(R.id.mainView)
        baseConvertRate = view.findViewById(R.id.baseConvertRate)
        currencyName = view.findViewById(R.id.currencyName)
        rateIcon = view.findViewById(R.id.rateIcon)
        rateContainer = view.findViewById(R.id.rateContainer)
    }

    private fun setDefaultValue(){
        currencyName.text = "EUR"
        val drawable: TextDrawable = TextDrawable.builder().buildRect(currencyName.text.toString(), Color.GRAY)
        rateIcon.setImageDrawable(drawable)
}

/*fun test(){
baseEditText.addTextChangedListener(object : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        viewModel.inputs.changeBaseValue(s.toString())
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

})
}*/
}
