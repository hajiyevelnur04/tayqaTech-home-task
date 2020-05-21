package com.eebros.myapplication.data.remote

import java.math.BigDecimal

data class GetBaseConvertResponse (
    val code: String,
    val alphaCode: String,
    val numericCode: String,
    val name: String,
    val rate: BigDecimal,
    val date: String,
    var inverseRate: BigDecimal
)
