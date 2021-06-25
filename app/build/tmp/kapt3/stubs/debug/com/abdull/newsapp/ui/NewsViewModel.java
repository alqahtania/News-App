package com.abdull.newsapp.ui;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u000e\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u0019\u001a\u00020\u001aH\u0002R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/abdull/newsapp/ui/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/content/Context;", "repository", "Lcom/abdull/newsapp/repository/abstraction/NewsRepository;", "(Landroid/content/Context;Lcom/abdull/newsapp/repository/abstraction/NewsRepository;)V", "_news", "Landroidx/lifecycle/MutableLiveData;", "Lcom/abdull/newsapp/util/Resource;", "", "Lcom/abdull/newsapp/model/Article;", "news", "Landroidx/lifecycle/LiveData;", "getNews", "()Landroidx/lifecycle/LiveData;", "newsPage", "", "getNewsPage", "()I", "setNewsPage", "(I)V", "Lkotlinx/coroutines/Job;", "query", "", "isConnectedToInternet", "", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    private final android.content.Context application = null;
    private final com.abdull.newsapp.repository.abstraction.NewsRepository repository = null;
    private final androidx.lifecycle.MutableLiveData<com.abdull.newsapp.util.Resource<java.util.List<com.abdull.newsapp.model.Article>>> _news = null;
    private int newsPage = 1;
    
    @javax.inject.Inject()
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context application, @org.jetbrains.annotations.NotNull()
    com.abdull.newsapp.repository.abstraction.NewsRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.abdull.newsapp.util.Resource<java.util.List<com.abdull.newsapp.model.Article>>> getNews() {
        return null;
    }
    
    public final int getNewsPage() {
        return 0;
    }
    
    public final void setNewsPage(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getNews(@org.jetbrains.annotations.Nullable()
    java.lang.String query, boolean isConnectedToInternet) {
        return null;
    }
    
    private final boolean isConnectedToInternet() {
        return false;
    }
}