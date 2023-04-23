package com.example.youtubeapi.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.databinding.FragmentPopularVideoBinding
import com.example.youtubeapi.ui.adapter.PopularVideoAdapter
import com.example.youtubeapi.ui.adapter.category.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularVideoFragment :
    BaseFragment<FragmentPopularVideoBinding, PopularVideoViewModel>(R.layout.fragment_popular_video) {

    override val binding by viewBinding(FragmentPopularVideoBinding::bind)
    override val viewModel: PopularVideoViewModel by viewModels()
    private val adapter = PopularVideoAdapter()
    private val categoryAdapter = CategoryAdapter()

    override fun initialize() {
        binding.categoryRecView.adapter = categoryAdapter
        binding.youtubeRecView.adapter = adapter
    }

    override fun setupSubscribes() {
        viewModel.fetchMostPopularVideos().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        }

        viewModel.videoCategoryRepository().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                categoryAdapter.submitList(it.items)
            }
        }
    }
}