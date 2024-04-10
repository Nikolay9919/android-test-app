package com.example.myapplication.domain.usecases.news

import androidx.paging.PagingData
import com.example.myapplication.domain.model.Article
import com.example.myapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> =
        newsRepository.getNews(sources = sources)
}
