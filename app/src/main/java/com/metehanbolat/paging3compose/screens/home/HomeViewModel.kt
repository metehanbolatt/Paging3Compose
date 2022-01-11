package com.metehanbolat.paging3compose.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.metehanbolat.paging3compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(repository: Repository): ViewModel() {
    val getAllImages = repository.getAllImages()
}