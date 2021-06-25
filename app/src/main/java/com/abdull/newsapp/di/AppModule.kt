package com.abdull.newsapp.di

import android.content.Context
import androidx.room.Room
import com.abdull.newsapp.datasource.local.ArticleDao
import com.abdull.newsapp.datasource.remote.NewsApi
import com.abdull.newsapp.datasource.local.ArticleDatabase
import com.abdull.newsapp.repository.abstraction.NewsRepository
import com.abdull.newsapp.repository.implementation.NewsRepositoryImpl
import com.abdull.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    val client = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient{
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit) : NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideNewsDatabase(
        @ApplicationContext context: Context
    ) : ArticleDatabase {
        return Room
            .databaseBuilder(context, ArticleDatabase::class.java, ArticleDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsRepository(db: ArticleDao, newsApi: NewsApi) : NewsRepository{

        return NewsRepositoryImpl(db, newsApi)

    }

    @Singleton
    @Provides
    fun provideArticleDao(articleDb : ArticleDatabase) : ArticleDao{
        return articleDb.articleDao()
    }



}