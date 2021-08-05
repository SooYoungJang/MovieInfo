package com.example.movieinfo.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieinfo.data.model.MovieItem
import kotlinx.coroutines.flow.Flow

@Dao
interface NaverMovieDao {

    @Insert
    suspend fun saveNaverMovieItemToDB(movieItem: MovieItem)

    @Query("SELECT * FROM MovieItem")
    fun getNaverMovieItemFromDB() : Flow<List<MovieItem>>
}