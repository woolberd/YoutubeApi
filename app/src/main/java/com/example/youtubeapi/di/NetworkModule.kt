package com.example.youtubeapi.di

import com.example.youtubeapi.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun fetchMostPopularVideos() = retrofitClient.fetchMostPopularVideos()

    @Singleton
    @Provides
    fun fetchVideoCategory() = retrofitClient.fetchVideoCategory()
}