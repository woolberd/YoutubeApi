package com.example.youtubeapi.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.youtubeapi.data.repository.PopularVideoRepository
import com.example.youtubeapi.data.repository.VideoCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularVideoViewModel @Inject constructor(
    private val repository: PopularVideoRepository,
    private val videoCategoryRepository: VideoCategoryRepository
) : ViewModel() {

    fun fetchMostPopularVideos() = repository.fetchVideos()

    fun videoCategoryRepository() = videoCategoryRepository.fetchCategory()
}