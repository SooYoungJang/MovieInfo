package com.example.movieinfo.presentation.di

import com.example.movieinfo.domain.usecase.GetMovieListUseCase
import com.example.movieinfo.presentation.viewmodelfactory.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieFactoryModule {

    @Singleton
    @Provides
    fun provideViewModelFactory(getMovieListUseCase: GetMovieListUseCase) : MovieViewModelFactory {
        return MovieViewModelFactory(getMovieListUseCase)
    }
}