package com.example.movieinfo.presentation.di

import com.example.movieinfo.data.api.NaverMovieApiService
import com.example.movieinfo.data.repository.datasource.MovieRemoteDataSource
import com.example.movieinfo.data.repository.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(movieApiService: NaverMovieApiService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(movieApiService)
    }

}