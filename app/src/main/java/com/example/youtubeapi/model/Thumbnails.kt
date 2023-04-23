package com.example.youtubeapi.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("maxres")
    val maxRes: MaxRes
)
