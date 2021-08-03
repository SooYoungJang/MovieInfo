package com.example.movieinfo.presentation.di

import com.example.movieinfo.BuildConfig
import com.example.movieinfo.data.api.NaverMovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit() :Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.NAVER_MOVIE_API_BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit) : NaverMovieApiService {
        return retrofit.create(NaverMovieApiService::class.java)
    }
}