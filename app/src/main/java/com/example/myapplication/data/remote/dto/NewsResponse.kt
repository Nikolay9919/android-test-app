package com.example.myapplication.data.remote.dto

import com.example.myapplication.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
