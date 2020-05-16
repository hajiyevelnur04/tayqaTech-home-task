package com.eebros.myapplication

import android.content.Context
import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

class TayqaInterceptor @Inject constructor(
    val context: Context,
    val activity: BaseActivity,
    val sharedPrefs: SharedPreferences
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        val fullResponseBody = response.body?.string()

        if(response.code == 200) {
            //do something
        }
        return response.newBuilder().body(ResponseBody.create(response.body?.contentType(), fullResponseBody!!)).build()
    }
}