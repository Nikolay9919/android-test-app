package com.example.myapplication.domain.usecases.news

import androidx.paging.PagingData
import com.example.myapplication.domain.model.Article
import com.example.myapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> =
        newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
}