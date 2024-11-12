package com.mogun.planetcoffee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mogun.planetcoffee.databinding.ItemMenuRowBinding

class MenuAdapter : ListAdapter<MenuItem, MenuAdapter.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemMenuRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(private val binding: ItemMenuRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuItem) {
            binding.nameTextView.text = item.name
            Glide.with(binding.imageView)
                .load(item.image)
                .circleCrop()
                .into(binding.imageView)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MenuItem>() {
            override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem) =
                oldItem === newItem

            override fun areContentsTheSame(
                oldItem: MenuItem,
                newItem: MenuItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}