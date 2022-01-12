package com.metehanbolat.paging3compose.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("result")
    val images: List<UnsplashImage>
)
