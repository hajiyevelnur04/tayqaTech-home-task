package com.eebros.myapplication.di.module.sub

import com.eebros.myapplication.Constants.Companion.BASE_URL
import com.eebros.myapplication.data.remote.service.ExchangeApiService
import com.eebros.myapplication.data.remote.service.ExchangeApiServiceProvider
import com.eebros.myapplication.domain.data.ExchangeRepository
import com.eebros.myapplication.domain.data.ExchangeRepositoryType
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

const val TAYQA_EXCHANGE = "tayqa_exchange"

@Module
class ExchangeModule {

    @Provides
    @Singleton
    fun providesExchangeApiServiceProvider(@Named(TAYQA_EXCHANGE) retrofit: Retrofit): ExchangeApiServiceProvider =
        object : ExchangeApiServiceProvider {
            val exchangeApiService = retrofit.create(ExchangeApiService::class.java)
            override fun getInstance() = exchangeApiService
        }

    @Named(TAYQA_EXCHANGE)
    @Provides
    @Singleton
    fun providesExchangeRetrofitInstance(
        callAdapterFactory: RxJava2CallAdapterFactory,
        converterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesExchangeRepository(serviceProvider: ExchangeApiServiceProvider): ExchangeRepositoryType {
        return ExchangeRepository(serviceProvider = serviceProvider)
    }
}