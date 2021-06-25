package com.abdull.newsapp.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdull.newsapp.model.Article
import com.abdull.newsapp.repository.abstraction.NewsRepository
import com.abdull.newsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject
constructor(
    @ApplicationContext private val application: Context,
    private val repository: NewsRepository
) : ViewModel() {

    private val _news: MutableLiveData<Resource<List<Article>>> = MutableLiveData()

    val news: LiveData<Resource<List<Article>>>
        get() = _news


    var newsPage = 1

    init {
        getNews("android")
    }

    fun getNews(query: String?, isConnectedToInternet : Boolean = isConnectedToInternet()) = viewModelScope.launch {

        repository.searchNews(query, newsPage, isConnectedToInternet).collect { result ->

            _news.postValue(result)
        }

    }

    private fun isConnectedToInternet(): Boolean {
        val connectManager = application.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectManager.activeNetwork ?: return false
            val networkCapabilities =
                connectManager.getNetworkCapabilities(activeNetwork) ?: return false

            return when {
                networkCapabilities.hasTransport(TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                networkCapabilities.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectManager.activeNetworkInfo?.run {
                return when (type) {
                    TYPE_WIFI -> true
                    TYPE_MOBILE -> true
                    TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }


}