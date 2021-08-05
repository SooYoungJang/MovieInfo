package com.example.movieinfo.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.data.model.NaverMovieApiResponse
import com.example.movieinfo.data.util.Resource
import com.example.movieinfo.domain.usecase.GetMovieListUseCase
import com.example.movieinfo.domain.usecase.SaveMovieListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel(private val getMovieListUseCase: GetMovieListUseCase, private val saveMovieListUseCase: SaveMovieListUseCase) : ViewModel(){

    var mutableLiveData = MutableLiveData<Resource<NaverMovieApiResponse>>()

    fun getMovieListFromApi(country:String, query: String) = viewModelScope.launch(Dispatchers.IO) {
        mutableLiveData.postValue(Resource.Loading())
        try {
            val resource  = getMovieListUseCase.execute(query,country)
            mutableLiveData.postValue(resource)
        }catch (e: Exception) {
            e.message?.let {
                mutableLiveData.postValue(Resource.Error(it))
            }
        }
    }

    fun saveMovieListUseCase(movieItem: MovieItem) = viewModelScope.launch(Dispatchers.IO) {
        saveMovieListUseCase.execute(movieItem)
    }

}