package com.eebros.myapplication

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainActivityAdapter (private val context: Context, fm: FragmentManager):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> CashConvertFragment()
            1 -> CashlessConvertFragment()
            else -> CashConvertFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> context.resources.getString(R.string.cash_converter)
            1 -> context.resources.getString(R.string.cashless_converter)
            else -> context.resources.getString(R.string.cash_converter)
        }
    }

    override fun getCount(): Int {
        return 2
    }
}