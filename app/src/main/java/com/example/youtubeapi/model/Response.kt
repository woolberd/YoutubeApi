package com.example.youtubeapi.model

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("prevPageToken")
    val prevPageToken: String = "",
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("nextPageToken")
    val nextPageToken: String = "",
    @SerializedName("pageInfo")
    val pageInfo: PageInfo,
    @SerializedName("etag")
    val etag: String = "",
    @SerializedName("items")
    val items: List<T>
)