package com.example.youtubeapi.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi.data.remote.apiservices.CategoryApiService
import com.example.youtubeapi.model.Response
import com.example.youtubeapi.model.YoutubeModel
import javax.inject.Inject

class VideoCategoryRepository @Inject constructor(
    private val categoryApiService: CategoryApiService
)  {

    fun fetchCategory(): LiveData<Response<YoutubeModel>> = liveData {
        val fetchCategory = categoryApiService.fetchVideoCategory()
        emit(fetchCategory)
    }
}