package com.example.movieinfo.presentation.adapter.userlikelist

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.databinding.UserLikeItemListBinding

class UserLikeMoveViewHolder(val binding: UserLikeItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movieItem: MovieItem) {
        binding.mvTitle.text = movieItem.title
        Glide.with(binding.mvItemImage.context)
            .load(movieItem.image)
            .into(binding.mvItemImage)
    }

}