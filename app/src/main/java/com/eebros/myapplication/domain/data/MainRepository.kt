package com.eebros.myapplication.domain.data

import com.eebros.myapplication.data.remote.service.MainApiServiceProvider
import com.eebros.myapplication.data.remote.Test
import io.reactivex.Single
import javax.inject.Inject

interface MainRepositoryType {
    fun test(): Single<Test>
    }

class MainRepository @Inject constructor(
    private val serviceProvider: MainApiServiceProvider
) : MainRepositoryType {

    override fun test()=
        serviceProvider.getInstance().test()

}
