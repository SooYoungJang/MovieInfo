package com.example.movieinfo.presentation.di

import com.example.movieinfo.domain.repository.MovieRepository
import com.example.movieinfo.domain.usecase.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsHeadLinesUseCase(movieRepository: MovieRepository) : GetMovieListUseCase {
        return GetMovieListUseCase(movieRepository)
    }
}