package com.abdull.newsapp.datasource.remote

import com.abdull.newsapp.model.APIResponse
import com.abdull.newsapp.util.Constants.NEWS_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        query: String? = "android",
        @Query("page")
        pageNum: Int = 1,
        @Query("apiKey")
        apiKey: String = NEWS_API_KEY
    ): Response<APIResponse>

}