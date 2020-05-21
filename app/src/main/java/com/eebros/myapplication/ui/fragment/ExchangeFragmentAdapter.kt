package com.eebros.myapplication.ui.fragment

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.eebros.myapplication.R
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import kotlinx.android.synthetic.main.exchange_item.view.*

class ExchangeFragmentAdapter(
    private val context: Context?,
    private val currencyList: List<GetBaseConvertResponse>,
    private val clickListeners: (position: Int) -> Unit
) : RecyclerView.Adapter<ExchangeFragmentAdapter.CashConvertFragmentAdapterViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    class CashConvertFragmentAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(currencyList: GetBaseConvertResponse, context: Context, clickListeners: (position: Int) -> Unit){
            itemView.name.text = currencyList.name
            itemView.date.text = currencyList.date
            itemView.inverseRate.text = currencyList.inverseRate.toString()
            itemView.rate.text = currencyList.rate.toString()
            val drawable: TextDrawable = TextDrawable.builder()
                .buildRect(currencyList.code, Color.GRAY)
            itemView.currencyIcon.setImageDrawable(drawable)
            //Picasso.with(context).load(currencyList.img).into(itemView.currencyIcon)
            itemView.setOnClickListener { clickListeners.invoke(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CashConvertFragmentAdapterViewHolder = CashConvertFragmentAdapterViewHolder(
        inflater.inflate(R.layout.exchange_item, parent, false)
    )

    override fun getItemCount() = currencyList.size

    override fun onBindViewHolder(holder: CashConvertFragmentAdapterViewHolder, position: Int) {
        if (context != null) {
            holder.bind(currencyList[position], context, clickListeners)
        }
    }
}
