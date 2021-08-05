package com.example.movieinfo.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieinfo.domain.usecase.GetMovieListUseCase
import com.example.movieinfo.domain.usecase.SaveMovieListUseCase
import com.example.movieinfo.presentation.viewmodel.MovieViewModel

class MovieViewModelFactory(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val saveMovieListUseCase: SaveMovieListUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieListUseCase, saveMovieListUseCase) as T
    }
}