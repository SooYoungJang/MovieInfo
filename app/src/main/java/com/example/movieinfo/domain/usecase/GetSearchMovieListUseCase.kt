package com.example.movieinfo.domain.usecase

import com.example.movieinfo.data.model.NaverMovieApiResponse
import com.example.movieinfo.data.util.Resource
import com.example.movieinfo.domain.repository.MovieRepository

class GetSearchMovieListUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(searchQuery: String) : Resource<NaverMovieApiResponse> {
        return movieRepository.getSearchMovieLists(searchQuery)
    }
}