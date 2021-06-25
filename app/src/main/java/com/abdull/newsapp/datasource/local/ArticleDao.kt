package com.abdull.newsapp.datasource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdull.newsapp.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(article: Article) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(article: List<Article>) : List<Long>

    @Query("SELECT * FROM article WHERE title LIKE '%' || :search || '%' LIMIT :pageSize ")
    suspend fun searchArticles(search: String? = "android", pageSize: Int) : List<Article>
}