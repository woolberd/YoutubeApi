package com.example.youtubeapi.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.base.BaseDiffUtilItemCallback
import com.example.youtubeapi.databinding.ItemCategoryBinding
import com.example.youtubeapi.model.YoutubeModel

class CategoryAdapter  : ListAdapter<YoutubeModel, CategoryAdapter.VideoViewHolder>(
    BaseDiffUtilItemCallback()
) {
    class VideoViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(youtubeModel: YoutubeModel) {
          binding.categoryText.text = youtubeModel.snippet.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}