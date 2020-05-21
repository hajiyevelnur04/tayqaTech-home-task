package com.eebros.myapplication

import java.math.BigDecimal

fun String.toBigDecimal(value: String): BigDecimal {
    return value.toBigDecimal()
}

class Constants {
    companion object {
        const val CHARSET = "Charset: UTF-8"
        const val CONTENT_TYPE_JSON = "content-type: application/json"
        const val ACCEPT = "Accept: application/json"
        const val BASE_URL = BuildConfig.TAYQA_URL
    }


}