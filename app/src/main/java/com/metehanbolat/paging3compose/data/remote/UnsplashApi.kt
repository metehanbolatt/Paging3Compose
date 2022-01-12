package com.metehanbolat.paging3compose.data.remote

import com.metehanbolat.paging3compose.BuildConfig
import com.metehanbolat.paging3compose.model.SearchResult
import com.metehanbolat.paging3compose.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImage(
        @Query(value = "page") page: Int,
        @Query(value = "per_page") perPage: Int
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query(value = "query") query: String,
        @Query(value = "per_page") perPage: Int
    ): SearchResult

}