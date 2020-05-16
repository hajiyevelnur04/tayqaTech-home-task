package com.eebros.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TayqaSessionManager @Inject constructor() {

    private val cachedUser: MediatorLiveData<ResponseModel> = MediatorLiveData()

    fun authenticateUser(customerResponseModel: LiveData<ResponseModel>) {
        cachedUser.value = null
        cachedUser.addSource(customerResponseModel) {
            cachedUser.value = it
            cachedUser.removeSource(customerResponseModel)
        }
    }

    fun getAuthUser() = cachedUser
}