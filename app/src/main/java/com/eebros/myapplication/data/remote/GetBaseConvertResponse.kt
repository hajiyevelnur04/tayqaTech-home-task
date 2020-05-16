package com.eebros.myapplication.data.remote

data class GetBaseConvertResponse (
    val code: String,
    val alphaCode: String,
    val numericCode: String,
    val name: String,
    val rate: Long,
    val date: String,
    val inverseRate: Long
)
