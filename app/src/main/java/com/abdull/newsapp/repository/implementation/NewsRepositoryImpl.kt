package com.abdull.newsapp.repository.implementation

import com.abdull.newsapp.datasource.local.ArticleDao
import com.abdull.newsapp.datasource.remote.NewsApi
import com.abdull.newsapp.model.Article
import com.abdull.newsapp.repository.abstraction.NewsRepository
import com.abdull.newsapp.util.Constants.PAGE_SIZE
import com.abdull.newsapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl
@Inject
constructor(
    private val dao: ArticleDao,
    private val api: NewsApi
) : NewsRepository {

    override fun searchNews(
        query: String?,
        pageNum: Int,
        hasInternetConnection: Boolean
    ): Flow<Resource<List<Article>>> = flow {


        emit(Resource.Loading())

        if (hasInternetConnection) {
            val response = api.searchNews(query, pageNum)

            if (response.isSuccessful) {
                response.body()?.let { apiResponse ->

                    val cacheList = apiResponse.articles.map {
                        it.copy(id = it.content.hashCode())
                    }
                    dao.insertAll(cacheList)
                }
            } else {
                emit(Resource.Error<List<Article>>(message = response.code().toString()))
            }
        }

        val queryList = dao.searchArticles(query, PAGE_SIZE * pageNum)

        emit(Resource.Success(queryList))

    }.catch { e ->
        emit(Resource.Error<List<Article>>(message = e.toString()))
    }.flowOn(Dispatchers.IO)


}