package com.eebros.myapplication

import io.reactivex.Single
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface MainApiService {
    @Headers(
        Constants.CONTENT_TYPE_JSON,
        Constants.CHARSET,
        Constants.ACCEPT
    )
    @POST("util/getCampaignById/{campaignId}")
    fun getCampaignById(
        @Path(value = "campaignId", encoded = true) campaignId: Long
    ): Single<Test>

}

interface MainApiServiceProvider : ServiceProvider<MainApiService>