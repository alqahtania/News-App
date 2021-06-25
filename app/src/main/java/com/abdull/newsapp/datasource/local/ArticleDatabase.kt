package com.abdull.newsapp.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abdull.newsapp.model.Article


@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DbTypeConverter::class)
abstract class ArticleDatabase : RoomDatabase(){

    abstract fun articleDao() : ArticleDao
    companion object{
        const val DATABASE_NAME = "news"
    }
}