package com.abdull.newsapp.repository.implementation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J4\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/abdull/newsapp/repository/implementation/NewsRepositoryImpl;", "Lcom/abdull/newsapp/repository/abstraction/NewsRepository;", "dao", "Lcom/abdull/newsapp/datasource/local/ArticleDao;", "api", "Lcom/abdull/newsapp/datasource/remote/NewsApi;", "(Lcom/abdull/newsapp/datasource/local/ArticleDao;Lcom/abdull/newsapp/datasource/remote/NewsApi;)V", "searchNews", "Lkotlinx/coroutines/flow/Flow;", "Lcom/abdull/newsapp/util/Resource;", "", "Lcom/abdull/newsapp/model/Article;", "query", "", "pageNum", "", "hasInternetConnection", "", "app_debug"})
@javax.inject.Singleton()
public final class NewsRepositoryImpl implements com.abdull.newsapp.repository.abstraction.NewsRepository {
    private final com.abdull.newsapp.datasource.local.ArticleDao dao = null;
    private final com.abdull.newsapp.datasource.remote.NewsApi api = null;
    
    @javax.inject.Inject()
    public NewsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.abdull.newsapp.datasource.local.ArticleDao dao, @org.jetbrains.annotations.NotNull()
    com.abdull.newsapp.datasource.remote.NewsApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.abdull.newsapp.util.Resource<java.util.List<com.abdull.newsapp.model.Article>>> searchNews(@org.jetbrains.annotations.Nullable()
    java.lang.String query, int pageNum, boolean hasInternetConnection) {
        return null;
    }
}