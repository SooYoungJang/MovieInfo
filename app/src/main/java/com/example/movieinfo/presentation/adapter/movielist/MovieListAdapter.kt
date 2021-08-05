package com.example.movieinfo.presentation.adapter.movielist

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.databinding.MovieListItemBinding

class MovieListAdapter(private val onClick: (MovieItem?, Int) -> Unit) : RecyclerView.Adapter<MovieListViewHolder>() {

    val callback = object : DiffUtil.ItemCallback<MovieItem>(){
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieListViewHolder(binding,onClick)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movieItems = differ.currentList[position]
        holder.bind(movieItems)
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }
}