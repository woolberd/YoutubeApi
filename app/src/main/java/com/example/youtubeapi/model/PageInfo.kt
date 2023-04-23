package com.example.youtubeapi.model

import com.google.gson.annotations.SerializedName

data class PageInfo(
    @SerializedName("totalResults")
    val totalResults: String = "",
    @SerializedName("resultsPerPage")
    val resultsPerPage: String = ""
)