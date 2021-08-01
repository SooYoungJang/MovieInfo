package com.example.movieinfo.domain.usecase

import com.example.movieinfo.data.model.NaverMovieApiResponse
import com.example.movieinfo.data.util.Resource
import com.example.movieinfo.domain.repository.MovieRepository

class GetMovieListUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : Resource<NaverMovieApiResponse> {
        return movieRepository.getMovieLists()
    }
}