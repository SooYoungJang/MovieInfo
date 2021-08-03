package com.example.movieinfo.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.databinding.MovieListItemBinding

class MovieListViewHolder(var binding: MovieListItemBinding) :RecyclerView.ViewHolder(binding.root)  {
    fun bind(movieItem: MovieItem) {
        binding.mvTitle.text = movieItem.title
        binding.mvSubTitle.text = movieItem.subtitle
        binding.mvPubDate.text = movieItem.pubDate
        binding.mvUserRating.text = movieItem.userRating
        Glide.with(binding.mvItemImage.context)
            .load(movieItem.image)
            .into(binding.mvItemImage)
    }
}