package com.example.myapplication.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val imageDrawable: Int
)

val pages = listOf(
    Page(
        title = "Dropbox",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        imageDrawable = R.drawable.dropbox_img
    ),
    Page(
        title = "Facebook",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        imageDrawable = R.drawable.facebook_img
    ),
    Page(
        title = "Ebay",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        imageDrawable = R.drawable.ebay_img
    )
)