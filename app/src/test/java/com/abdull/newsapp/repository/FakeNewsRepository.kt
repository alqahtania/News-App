package com.abdull.newsapp.repository

import com.abdull.newsapp.model.Article
import com.abdull.newsapp.repository.abstraction.NewsRepository
import com.abdull.newsapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNewsRepository(
    val network: MutableList<Article>,
    val local: MutableList<Article>
) : NewsRepository {


    override fun searchNews(
        query: String?,
        pageNum: Int,
        hasInternetConnection: Boolean
    ): Flow<Resource<List<Article>>> = flow {

        val qry = query ?: ""
        if (hasInternetConnection) {
            for(article in network){
                val title = article.title ?: ""
                if(title.contains(qry, ignoreCase = true)){
                    local.add(article.copy(id = article.content.hashCode()))
                }
            }
        }else{
            emit(Resource.Error<List<Article>>(message = "error check your network connection"))
        }


        emit(Resource.Success(local.toList()))

    }
}