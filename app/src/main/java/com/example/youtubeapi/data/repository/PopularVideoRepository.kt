package com.example.youtubeapi.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.youtubeapi.data.remote.apiservices.YoutubeApiService
import com.example.youtubeapi.data.repository.pagingsource.PopularVideoPagingSource
import javax.inject.Inject

class PopularVideoRepository @Inject constructor(
    private val popularVideoApiService: YoutubeApiService
) {

    fun fetchVideos() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 20)
    ) {
        PopularVideoPagingSource(popularVideoApiService)
    }.liveData
}