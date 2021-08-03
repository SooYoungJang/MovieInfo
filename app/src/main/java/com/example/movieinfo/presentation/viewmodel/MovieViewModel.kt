package com.example.movieinfo.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.data.model.NaverMovieApiResponse
import com.example.movieinfo.data.util.Resource
import com.example.movieinfo.domain.usecase.GetMovieListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel(private val getMovieListUseCase: GetMovieListUseCase) : ViewModel(){

    var mutableLiveData = MutableLiveData<Resource<NaverMovieApiResponse>>()

    fun getMovieList(country:String, query: String) = viewModelScope.launch(Dispatchers.IO) {
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
}