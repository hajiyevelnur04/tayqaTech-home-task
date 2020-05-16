package com.eebros.myapplication.data.remote.service

import com.eebros.myapplication.Constants
import com.eebros.myapplication.data.remote.Test
import com.eebros.myapplication.data.remote.provider.ServiceProvider
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface MainApiService {
    @Headers(
        Constants.CONTENT_TYPE_JSON,
        Constants.CHARSET,
        Constants.ACCEPT
    )
    @GET("rates.php")
    fun test(): Single<Test>

}

interface MainApiServiceProvider :
    ServiceProvider<MainApiService>