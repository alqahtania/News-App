package com.abdull.newsapp.repository.abstraction

import com.abdull.newsapp.model.Article
import com.abdull.newsapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

     fun searchNews(query: String?, pageNum : Int, hasInternetConnection : Boolean) : Flow<Resource<List<Article>>>

}