package com.example.youtubeapi.model

import com.example.youtubeapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class YoutubeModel(
    @SerializedName("id")
    override val id: String,
    @SerializedName("snippet")
    val snippet: Snippet,
    @SerializedName("statistics")
    val statistics: Statistics
): IBaseDiffModel
