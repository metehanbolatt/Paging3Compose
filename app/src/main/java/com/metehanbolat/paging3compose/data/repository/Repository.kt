package com.metehanbolat.paging3compose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.metehanbolat.paging3compose.data.local.UnsplashDatabase
import com.metehanbolat.paging3compose.data.paging.UnsplashRemoteMediator
import com.metehanbolat.paging3compose.data.remote.UnsplashApi
import com.metehanbolat.paging3compose.model.UnsplashImage
import com.metehanbolat.paging3compose.util.Constants
import com.metehanbolat.paging3compose.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {

    @ExperimentalPagingApi
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}