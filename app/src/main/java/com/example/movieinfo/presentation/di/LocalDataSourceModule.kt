package com.example.movieinfo.presentation.di

import com.example.movieinfo.data.db.dao.NaverMovieDao
import com.example.movieinfo.data.repository.datasource.MovieLocalDataSource
import com.example.movieinfo.data.repository.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {


    @Singleton
    @Provides
    fun provideLocalDataSource(naverMovieDao: NaverMovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(naverMovieDao)
    }
}