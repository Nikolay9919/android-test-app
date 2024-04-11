package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.data.manager.LocalUserManagerImpl
import com.example.myapplication.data.remote.NewsApi
import com.example.myapplication.data.repository.NewsRepositoryImpl
import com.example.myapplication.domain.manager.LocalUserManager
import com.example.myapplication.domain.repository.NewsRepository
import com.example.myapplication.domain.usecases.appEntry.AppEntryUseCases
import com.example.myapplication.domain.usecases.appEntry.ReadAppEntry
import com.example.myapplication.domain.usecases.appEntry.SaveAppEntry
import com.example.myapplication.domain.usecases.news.GetNews
import com.example.myapplication.domain.usecases.news.NewsUseCases
import com.example.myapplication.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)


    @Provides
    @Singleton
    fun providesNewRepository(newsApi: NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases =
        NewsUseCases(getNews = GetNews(newsRepository))
}