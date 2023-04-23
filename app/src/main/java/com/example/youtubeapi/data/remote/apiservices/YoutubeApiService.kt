package com.example.youtubeapi.data.remote.apiservices

import com.example.youtubeapi.model.Response
import com.example.youtubeapi.model.YoutubeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApiService {

    @GET("videos")
    suspend fun fetchMostPopularVideos(
        @Query("regionCode") regionCode: String = "ru",
        @Query("part") part: String = "snippet,statistics",
        @Query("chart") chart: String = "mostPopular",
        @Query("pageToken") pageToken: String
    ): Response<YoutubeModel>
}