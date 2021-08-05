package com.example.movieinfo.data.repository.datasource

import com.example.movieinfo.data.model.MovieItem
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    suspend fun saveMovieLists(movieItem: MovieItem)
    fun getMovieLists() : Flow<List<MovieItem>>
}