package com.example.movieinfo.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieinfo.data.db.dao.NaverMovieDao
import com.example.movieinfo.data.model.MovieItem


@Database(entities = [MovieItem::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao() : NaverMovieDao
}