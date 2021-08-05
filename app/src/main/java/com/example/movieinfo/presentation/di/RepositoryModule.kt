package com.example.movieinfo.presentation.di

import com.example.movieinfo.data.repository.MovieRepositoryImpl
import com.example.movieinfo.data.repository.datasource.MovieLocalDataSource
import com.example.movieinfo.data.repository.datasource.MovieRemoteDataSource
import com.example.movieinfo.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepositoryDataSource(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource)
    }
}