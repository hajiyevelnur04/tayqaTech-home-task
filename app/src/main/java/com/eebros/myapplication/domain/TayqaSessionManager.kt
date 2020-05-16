package com.eebros.myapplication.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.eebros.myapplication.data.remote.GetBaseConvertResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TayqaSessionManager @Inject constructor() {

    private val cachedUser: MediatorLiveData<GetBaseConvertResponse> = MediatorLiveData()

    fun authenticateUser(customerGetBaseConvertResponse: LiveData<GetBaseConvertResponse>) {
        cachedUser.value = null
        cachedUser.addSource(customerGetBaseConvertResponse) {
            cachedUser.value = it
            cachedUser.removeSource(customerGetBaseConvertResponse)
        }
    }

    fun getAuthUser() = cachedUser
}