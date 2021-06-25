package com.abdull.newsapp.repository.abstraction;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/abdull/newsapp/repository/abstraction/NewsRepository;", "", "searchNews", "Lkotlinx/coroutines/flow/Flow;", "Lcom/abdull/newsapp/util/Resource;", "", "Lcom/abdull/newsapp/model/Article;", "query", "", "pageNum", "", "hasInternetConnection", "", "app_debug"})
public abstract interface NewsRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.abdull.newsapp.util.Resource<java.util.List<com.abdull.newsapp.model.Article>>> searchNews(@org.jetbrains.annotations.Nullable()
    java.lang.String query, int pageNum, boolean hasInternetConnection);
}