package com.mogun.planetcoffee

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mogun.planetcoffee.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val homeData = context?.readData() ?: return
        binding.appBarTitleTextView.text = getString(R.string.appbar_title_text, homeData.user.nickname)
        binding.starCountTextView.text = getString(R.string.appbar_start_title, homeData.user.startCount)

        binding.progressBar.progress = homeData.user.startCount
        binding.progressBar.max = homeData.user.totalCount

        Glide.with(binding.appBarImageView)
            .load(homeData.appbarImage)
            .into(binding.appBarImageView)
    }
}