package com.example.movieinfo.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieinfo.domain.usecase.GetSaveMovieListUseCase
import com.example.movieinfo.presentation.viewmodel.UserLikeViewModel

class UserLikeMovieViewModelFactory(private val getSaveMovieListUseCase: GetSaveMovieListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserLikeViewModel(getSaveMovieListUseCase) as T
    }
}