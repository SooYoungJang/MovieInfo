package com.example.movieinfo.presentation.di

import com.example.movieinfo.domain.repository.MovieRepository
import com.example.movieinfo.domain.usecase.GetMovieListUseCase
import com.example.movieinfo.domain.usecase.GetSaveMovieListUseCase
import com.example.movieinfo.domain.usecase.SaveMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.annotation.Signed
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieApiUseCase(movieRepository: MovieRepository): GetMovieListUseCase {
        return GetMovieListUseCase(movieRepository)
    }


    @Singleton
    @Provides
    fun provideGetMovieDBUseCase(movieRepository: MovieRepository): GetSaveMovieListUseCase {
        return GetSaveMovieListUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideSaveMovieDBUseCase(movieRepository: MovieRepository): SaveMovieListUseCase {
        return SaveMovieListUseCase(movieRepository)
    }
}