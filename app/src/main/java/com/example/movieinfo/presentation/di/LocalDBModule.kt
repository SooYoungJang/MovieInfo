package com.example.movieinfo.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.movieinfo.data.db.dao.NaverMovieDao
import com.example.movieinfo.data.db.database.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDBModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(app:Application) : MovieDatabase {
        return Room.databaseBuilder(app, MovieDatabase::class.java,"naver_movie_database" )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNaverMovieDao(movieDatabase: MovieDatabase) : NaverMovieDao {
        return movieDatabase.getMovieDao()
    }

}