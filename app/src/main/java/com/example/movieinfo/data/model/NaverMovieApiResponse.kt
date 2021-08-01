package com.example.movieinfo.data.model


import com.google.gson.annotations.SerializedName

data class NaverMovieApiResponse(
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val movieItems: List<MovieItem>,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("total")
    val total: Int
)