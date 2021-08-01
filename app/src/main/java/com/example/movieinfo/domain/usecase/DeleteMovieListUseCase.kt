package com.example.movieinfo.domain.usecase

import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.domain.repository.MovieRepository

class DeleteMovieListUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(movieItem: MovieItem) {
        movieRepository.deleteMovieLists(movieItem)
    }
}