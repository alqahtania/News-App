package com.abdull.newsapp.di

import com.abdull.newsapp.repository.FakeNewsRepository

class DependencyContainer {


    lateinit var dataFactory: DataFactory
    lateinit var newsRepository: FakeNewsRepository


    fun build() {
        this.javaClass.classLoader?.let { classLoader ->
            dataFactory = DataFactory(classLoader)
        }
        val articleList = dataFactory.produceListOfArticles()

        newsRepository = FakeNewsRepository(
            network = articleList,
            local = mutableListOf()
        )
    }
}