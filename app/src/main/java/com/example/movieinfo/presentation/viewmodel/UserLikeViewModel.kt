package com.example.movieinfo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.domain.usecase.GetSaveMovieListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

class UserLikeViewModel(private val getSaveMovieListUseCase: GetSaveMovieListUseCase) : ViewModel(){

    var mutableLiveData = MutableLiveData<List<MovieItem>>()

    fun getMovieListFromDB() = liveData {
        getSaveMovieListUseCase.execute().collect {
            emit(it)
        }
    }
}