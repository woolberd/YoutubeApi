package com.example.youtubeapi.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY = "AIzaSyBadk87VUxq3u-rntg5_Qkr0dcyXaQJG0c"

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("key", API_KEY).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}