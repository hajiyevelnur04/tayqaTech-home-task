package com.eebros.myapplication.di.module.sub

import com.eebros.myapplication.Constants.Companion.BASE_URL
import com.eebros.myapplication.data.remote.service.MainApiService
import com.eebros.myapplication.data.remote.service.MainApiServiceProvider
import com.eebros.myapplication.domain.data.MainRepository
import com.eebros.myapplication.domain.data.MainRepositoryType
import com.eebros.myapplication.di.scope.MainScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

const val MLB_MAIN = "tayqa_main"

@Module
class MainModule {
    @Provides
    @MainScope
    fun providesMainRepository(serviceProvider: MainApiServiceProvider): MainRepositoryType {
        return MainRepository(
            serviceProvider = serviceProvider
        )
    }

    @Provides
    @MainScope
    fun providesMainApiServiceProvider(@Named(MLB_MAIN) retrofit: Retrofit): MainApiServiceProvider =
        object :
            MainApiServiceProvider {
            val mainApiService = retrofit.create(MainApiService::class.java)
            override fun getInstance() = mainApiService
        }

    @Named(MLB_MAIN)
    @Provides
    @MainScope
    fun providesRetrofitInstance(
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
}