package com.example.movieinfo.data.repository.datasourceImpl

import com.example.movieinfo.data.db.dao.NaverMovieDao
import com.example.movieinfo.data.model.MovieItem
import com.example.movieinfo.data.repository.datasource.MovieLocalDataSource
import kotlinx.coroutines.flow.Flow

class MovieLocalDataSourceImpl(private val naverMovieDao: NaverMovieDao) :MovieLocalDataSource {

    override suspend fun saveMovieLists(movieItem: MovieItem) {
        naverMovieDao.saveNaverMovieItemToDB(movieItem)
    }

    override fun getMovieLists(): Flow<List<MovieItem>> {
       return naverMovieDao.getNaverMovieItemFromDB()
    }
}