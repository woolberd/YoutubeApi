package com.example.youtubeapi.data.remote.apiservices

import com.example.youtubeapi.model.Response
import com.example.youtubeapi.model.YoutubeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryApiService {

    @GET("videoCategories")
    suspend fun fetchVideoCategory(
        @Query("part") part: String = "snippet",
        @Query("regionCode")regionCode: String = "ru"
    ) : Response<YoutubeModel>
}