package com.example.movieinfo.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.movieinfo.R
import com.example.movieinfo.databinding.ActivityMainBinding
import com.example.movieinfo.presentation.viewmodel.MovieViewModel
import com.example.movieinfo.presentation.viewmodel.UserLikeViewModel
import com.example.movieinfo.presentation.viewmodelfactory.MovieViewModelFactory
import com.example.movieinfo.presentation.viewmodelfactory.UserLikeMovieViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory
    lateinit var movieListViewModel: MovieViewModel

    lateinit var userLikeViewModel: UserLikeViewModel
    @Inject
    lateinit var userLikeViewModelFactory: UserLikeMovieViewModelFactory

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        movieListViewModel = ViewModelProvider(this,viewModelFactory).get(MovieViewModel::class.java)
        userLikeViewModel = ViewModelProvider(this,userLikeViewModelFactory).get(UserLikeViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.button.setOnClickListener {
            navController.navigate(R.id.action_movieListFragment_to_userLikeMovieInfoFragment)
        }

    }
}