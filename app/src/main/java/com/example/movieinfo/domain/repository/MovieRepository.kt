package com.example.movieinfo.domain.repository

import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.data.model.NaverMovieApiResponse
import com.example.movieinfo.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieLists() : Resource<NaverMovieApiResponse>
    suspend fun getSearchMovieLists(searchQuery: String) : Resource<NaverMovieApiResponse>
    suspend fun deleteMovieLists(movieItem: MovieItem)
    suspend fun saveMovieLists(movieItem: MovieItem)
    fun getSaveMovieLists() : Flow<List<MovieItem>>
}