package com.example.movieinfo.presentation.adapter.movielist

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.databinding.MovieListItemBinding

class MovieListViewHolder(
    var binding: MovieListItemBinding,
    private val onClick: (MovieItem?, Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movieItem: MovieItem) {
        binding.mvTitle.text = movieItem.title
        Glide.with(binding.mvItemImage.context)
            .load(movieItem.image)
            .into(binding.mvItemImage)

        binding.itemButton.setOnClickListener {
            onClick(movieItem, adapterPosition)
        }
    }
}