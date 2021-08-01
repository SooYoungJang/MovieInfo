package com.example.movieinfo.domain.usecase

import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetSaveMovieListUseCase(private val movieRepository: MovieRepository) {

    fun execute() : Flow<List<MovieItem>> {
       return movieRepository.getSaveMovieLists()
    }
}