package com.eebros.myapplication.domain.data

import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import com.eebros.myapplication.data.remote.service.ExchangeApiServiceProvider
import io.reactivex.Observable
import javax.inject.Inject

interface ExchangeRepositoryType {
    fun getBaseConvert(base: String): Observable<ArrayList<GetBaseConvertResponse>>
}

class ExchangeRepository @Inject constructor(private val serviceProvider: ExchangeApiServiceProvider) : ExchangeRepositoryType {
    override fun getBaseConvert(base: String) = serviceProvider.getInstance().getBaseConvert(base)

}
