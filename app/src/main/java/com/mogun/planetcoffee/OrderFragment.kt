package com.mogun.planetcoffee

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mogun.planetcoffee.databinding.FragmentOrderBinding
import kotlin.math.abs

class OrderFragment: Fragment(R.layout.fragment_order) {

    private lateinit var binding: FragmentOrderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)

        val menuData = context?.readData("menu.json", Menu::class.java) ?: return
        val menuAdapter = MenuAdapter().apply {
            submitList(menuData.coffee)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = menuAdapter
        }

        binding.appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val seekPosition = abs(verticalOffset) / appBarLayout.totalScrollRange.toFloat()
            binding.motionLayout.progress = seekPosition
        }
    }
}