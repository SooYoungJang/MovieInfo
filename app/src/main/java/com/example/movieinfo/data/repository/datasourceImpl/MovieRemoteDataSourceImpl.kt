package com.example.movieinfo.data.repository.datasourceImpl

import android.util.Log
import com.example.movieinfo.data.api.NaverMovieApiService
import com.example.movieinfo.data.model.NaverMovieApiResponse
import com.example.movieinfo.data.repository.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val naverMovieApiService: NaverMovieApiService

) : MovieRemoteDataSource {

    override suspend fun getMovieLists(country : String, query: String): Response<NaverMovieApiResponse> {
        return naverMovieApiService.getIronManMovieList(query,country)
    }
}