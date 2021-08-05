package com.example.movieinfo.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo.R
import com.example.movieinfo.databinding.FragmentUserLikeMovieInfoBinding
import com.example.movieinfo.presentation.adapter.userlikelist.UserLikeMovieListAdapter
import com.example.movieinfo.presentation.viewmodel.UserLikeViewModel

class UserLikeMovieInfoFragment : Fragment() {

    private lateinit var binding: FragmentUserLikeMovieInfoBinding
    private lateinit var viewModel: UserLikeViewModel
    private lateinit var adapter: UserLikeMovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_like_movie_info,container,false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).userLikeViewModel
        initRecycleView()
        viewUserLikeItem()
    }

    private fun initRecycleView() {
        adapter = UserLikeMovieListAdapter()
        binding.userLikeRcv.adapter = adapter
        binding.userLikeRcv.layoutManager = LinearLayoutManager(activity)
    }

    private fun viewUserLikeItem() {
        viewModel.getMovieListFromDB().observe(viewLifecycleOwner, Observer {
            adapter.differ.submitList(it)
        })
    }
}