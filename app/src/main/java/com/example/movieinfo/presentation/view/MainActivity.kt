package com.example.movieinfo.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.movieinfo.R
import com.example.movieinfo.databinding.ActivityMainBinding
import com.example.movieinfo.presentation.viewmodel.MovieViewModel
import com.example.movieinfo.presentation.viewmodelfactory.MovieViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory

    lateinit var viewModel: MovieViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MovieViewModel::class.java)

    }
}