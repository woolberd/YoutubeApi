package com.example.youtubeapi.model

import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("viewCount")
    val viewCount: String? = null,
    @SerializedName("likeCount")
    val likeCount: String
)