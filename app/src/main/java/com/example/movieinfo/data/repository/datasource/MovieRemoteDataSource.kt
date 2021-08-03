package com.example.movieinfo.data.repository.datasource

import com.example.movieinfo.data.model.NaverMovieApiResponse
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovieLists(country:String, query: String) : Response<NaverMovieApiResponse>

}