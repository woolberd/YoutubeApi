package com.example.youtubeapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi.base.BaseDiffUtilItemCallback
import com.example.youtubeapi.databinding.ItemDataBinding
import com.example.youtubeapi.model.YoutubeModel

class PopularVideoAdapter :
    PagingDataAdapter<YoutubeModel, PopularVideoAdapter.VideoViewHolder>(BaseDiffUtilItemCallback()) {
    class VideoViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(youtubeModel: YoutubeModel) {
            Glide.with(binding.imgDale).load(youtubeModel.snippet.thumbnails.maxRes.url)
                .into(binding.imgDale)
            binding.peopleWatch.text = youtubeModel.statistics.viewCount
            binding.yearOfIssue.text = youtubeModel.snippet.publishedAt
            binding.textVidName.text = youtubeModel.snippet.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}