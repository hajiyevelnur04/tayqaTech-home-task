package com.eebros.myapplication.data.remote.provider

interface DependencyProvider<INSTANCE_TYPE> {
    fun getInstance(): INSTANCE_TYPE
}