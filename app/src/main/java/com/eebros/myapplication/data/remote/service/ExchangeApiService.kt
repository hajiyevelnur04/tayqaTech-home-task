package com.eebros.myapplication.data.remote.service

import com.eebros.myapplication.Constants
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import com.eebros.myapplication.data.remote.provider.ServiceProvider
import io.reactivex.Observable
import retrofit2.http.*

interface ExchangeApiService {
    @Headers(
        Constants.CONTENT_TYPE_JSON,
        Constants.CHARSET,
        Constants.ACCEPT
    )
    @GET("rates.php")
    fun getBaseConvert(@Query(value = "base") base: String): Observable<ArrayList<GetBaseConvertResponse>>

}

interface ExchangeApiServiceProvider :
    ServiceProvider<ExchangeApiService>