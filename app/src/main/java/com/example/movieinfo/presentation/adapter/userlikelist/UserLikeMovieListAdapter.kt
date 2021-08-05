package com.example.movieinfo.presentation.adapter.userlikelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.databinding.UserLikeItemListBinding

class UserLikeMovieListAdapter : RecyclerView.Adapter<UserLikeMoveViewHolder>() {

    var callback = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserLikeMoveViewHolder {
        val binding = UserLikeItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserLikeMoveViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserLikeMoveViewHolder, position: Int) {
        return holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}