package com.example.movieinfo.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo.R
import com.example.movieinfo.data.util.Resource
import com.example.movieinfo.databinding.FragmentMovieListBinding
import com.example.movieinfo.presentation.adapter.MovieListAdapter
import com.example.movieinfo.presentation.viewmodel.MovieViewModel
import com.example.movieinfo.presentation.viewmodelfactory.MovieViewModelFactory


class MovieListFragment : Fragment() {

    private lateinit var movieListBinding: FragmentMovieListBinding
    private lateinit var movieAdapter: MovieListAdapter
    private lateinit var viewModel: MovieViewModel
    private var country = "US"
    private var query = "아이언맨"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieListBinding = FragmentMovieListBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel

        initRecyclerView()
        viewMovieList()

    }

    private fun initRecyclerView() {
        movieAdapter = MovieListAdapter()
        movieListBinding.movieListRcv.adapter = movieAdapter
        movieListBinding.movieListRcv.layoutManager = LinearLayoutManager(activity)
    }

    private fun viewMovieList() {
        viewModel.getMovieList(country, query)
        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let {
                        movieAdapter.differ.submitList(it.movieItems.toList())
                    }
                }
                is Resource.Error -> {
                    response.data?.let {
                        Toast.makeText(activity,"errorr message response", Toast.LENGTH_SHORT).show()
                    }
                }
                is Resource.Loading -> {
                }
            }
        })
    }
}