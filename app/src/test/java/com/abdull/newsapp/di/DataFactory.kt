package com.abdull.newsapp.di

import com.abdull.newsapp.model.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataFactory(
    private val testClassLoader: ClassLoader
) {


    private val jsonFile = "article_list.json"

    fun produceListOfArticles(): MutableList<Article> {
        val articles: MutableList<Article> = Gson()
            .fromJson(
                getArticlesFromFile(jsonFile),
                object : TypeToken<MutableList<Article>>() {}.type
            )
        return articles
    }


    fun getArticlesFromFile(fileName: String): String {
        return testClassLoader.getResource(fileName).readText()
    }
}