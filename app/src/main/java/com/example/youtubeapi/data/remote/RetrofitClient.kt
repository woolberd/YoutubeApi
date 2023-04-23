package com.example.youtubeapi.data.remote

import com.example.youtubeapi.data.remote.apiservices.CategoryApiService
import com.example.youtubeapi.data.remote.apiservices.YoutubeApiService
import com.example.youtubeapi.data.remote.interceptor.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(ApiKeyInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun fetchMostPopularVideos() = retrofitClient.create(YoutubeApiService::class.java)

    fun fetchVideoCategory() = retrofitClient.create(CategoryApiService::class.java)
}