package com.example.movieinfo.presentation.di

import com.example.movieinfo.domain.usecase.GetSaveMovieListUseCase
import com.example.movieinfo.presentation.viewmodelfactory.UserLikeMovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserLikeFactoryModule {


    @Singleton
    @Provides
    fun provideUserLikeFactory(getSaveMovieListUseCase: GetSaveMovieListUseCase) : UserLikeMovieViewModelFactory {
        return UserLikeMovieViewModelFactory(getSaveMovieListUseCase)
    }
}