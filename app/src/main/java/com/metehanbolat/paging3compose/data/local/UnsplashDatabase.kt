package com.metehanbolat.paging3compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.metehanbolat.paging3compose.data.local.dao.UnsplashImageDao
import com.metehanbolat.paging3compose.data.local.dao.UnsplashRemoteKeysDao
import com.metehanbolat.paging3compose.model.UnsplashImage
import com.metehanbolat.paging3compose.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase: RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}