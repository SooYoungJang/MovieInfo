package com.example.movieinfo.data.api

import com.example.movieinfo.BuildConfig
import com.example.movieinfo.data.model.NaverMovieApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverMovieApiService {
    @GET("/v1/search/movie.json")
    suspend fun getIronManMovieList (
        @Query("query") query: String,
        @Query("country") country: String,
        @Header("X-Naver-Client-Id") clientId : String = BuildConfig.NAVER_MY_CLIENT_ID,
        @Header("X-Naver-Client-Secret") clientSecretKey:String = BuildConfig.NAVER_MY_CLIENT_SECRET_KEY
    ) : Response<NaverMovieApiResponse>
}