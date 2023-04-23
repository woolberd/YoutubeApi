package com.example.youtubeapi.data.repository.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.youtubeapi.data.remote.apiservices.YoutubeApiService
import com.example.youtubeapi.model.YoutubeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val PAGE_TOKEN = " "

class PopularVideoPagingSource(private val popularVideoApiService: YoutubeApiService) :
    PagingSource<String, YoutubeModel>() {

    override fun getRefreshKey(state: PagingState<String, YoutubeModel>): String? {
        var current: String? = " "

        val anchorPosition = state.anchorPosition

        CoroutineScope(Dispatchers.IO).launch {
            if (anchorPosition != null) {
                current = state.closestPageToPosition(anchorPosition)?.prevKey?.let {
                    popularVideoApiService.fetchMostPopularVideos(
                        pageToken = it
                    ).nextPageToken
                }
            }
        }
        return current
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, YoutubeModel> {
        return try {
            val startPage = params.key ?: PAGE_TOKEN
            val response = popularVideoApiService.fetchMostPopularVideos(
                pageToken = startPage
            )
            val nextPage = if (response.items.isEmpty()) null else response.nextPageToken
            val prevPage = if (startPage == PAGE_TOKEN) null else response.prevPageToken

            LoadResult.Page(
                data = response.items,
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}