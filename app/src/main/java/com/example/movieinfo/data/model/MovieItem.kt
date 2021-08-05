package com.example.movieinfo.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MovieItem(
    @PrimaryKey
    @SerializedName("id")
    val id : Int?,
    @SerializedName("actor")
    val actor: String?,
    @SerializedName("director")
    val director: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("pubDate")
    val pubDate: String?,
    @SerializedName("subtitle")
    val subtitle: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userRating")
    val userRating: String?
)