package com.eebros.myapplication.ui.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eebros.myapplication.R
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import kotlinx.android.synthetic.main.currency_item.view.*

class CashConvertFragmentAdapter(
    private val context: Context?,
    private val currencyList: List<GetBaseConvertResponse>,
    private val clickListeners: (position: Int) -> Unit
) : RecyclerView.Adapter<CashConvertFragmentAdapter.CashConvertFragmentAdapterViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    class CashConvertFragmentAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(currencyList: GetBaseConvertResponse, context: Context, clickListeners: (position: Int) -> Unit){
            itemView.name.text = currencyList.name
            itemView.date.text = currencyList.date
            itemView.name.text = currencyList.inverseRate.toString()
            itemView.name.text = currencyList.rate.toString()
            //Picasso.with(context).load(currencyList.img).into(itemView.currencyIcon)
            itemView.setOnClickListener { clickListeners.invoke(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CashConvertFragmentAdapterViewHolder = CashConvertFragmentAdapterViewHolder(
        inflater.inflate(R.layout.currency_item, parent, false)
    )

    override fun getItemCount() = currencyList.size

    override fun onBindViewHolder(holder: CashConvertFragmentAdapterViewHolder, position: Int) {
        if (context != null) {
            holder.bind(currencyList[position], context, clickListeners)
        }
    }
}
