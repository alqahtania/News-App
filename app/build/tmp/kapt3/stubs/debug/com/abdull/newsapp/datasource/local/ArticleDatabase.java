package com.abdull.newsapp.datasource.local;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.abdull.newsapp.datasource.local.DbTypeConverter.class})
@androidx.room.Database(entities = {com.abdull.newsapp.model.Article.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/abdull/newsapp/datasource/local/ArticleDatabase;", "Landroidx/room/RoomDatabase;", "()V", "articleDao", "Lcom/abdull/newsapp/datasource/local/ArticleDao;", "Companion", "app_debug"})
public abstract class ArticleDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.abdull.newsapp.datasource.local.ArticleDatabase.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "news";
    
    public ArticleDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.abdull.newsapp.datasource.local.ArticleDao articleDao();
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/abdull/newsapp/datasource/local/ArticleDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}