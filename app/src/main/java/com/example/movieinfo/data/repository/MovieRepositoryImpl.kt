package com.example.movieinfo.data.repository

import android.util.Log
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.data.model.NaverMovieApiResponse
import com.example.movieinfo.data.repository.datasource.MovieLocalDataSource
import com.example.movieinfo.data.repository.datasource.MovieRemoteDataSource
import com.example.movieinfo.data.util.Resource
import com.example.movieinfo.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getMovieLists(
        query: String,
        country: String
    ): Resource<NaverMovieApiResponse> {
        return responseToResource(movieRemoteDataSource.getMovieLists(query, country))
    }

    private fun responseToResource(resource: Response<NaverMovieApiResponse>): Resource<NaverMovieApiResponse> {
        if (resource.isSuccessful) {
            resource.body()?.let {
                Log.d("tggg,", " whtwhtwht 111 ${it.toString()}");
                return Resource.Success(it)
            }
        }
        Log.d("tggg,", " whtwhtwht 222");
        return Resource.Error(resource.message())
    }

    override suspend fun getSearchMovieLists(searchQuery: String): Resource<NaverMovieApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovieLists(movieItem: MovieItem) {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovieLists(movieItem: MovieItem) {
        movieLocalDataSource.saveMovieLists(movieItem)
    }

    override fun getSaveMovieLists(): Flow<List<MovieItem>> {
        return movieLocalDataSource.getMovieLists()
    }
}