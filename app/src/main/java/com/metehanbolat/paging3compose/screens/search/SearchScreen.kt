package com.metehanbolat.paging3compose.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.metehanbolat.paging3compose.screens.common.ListContent

@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
    val searchedImages = searchViewModel.searchedImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchWidget(
                text = searchQuery,
                onTextChanged = { searchViewModel.updateSearchQuery(query = it) },
                onSearchClicked = { searchViewModel.searchHeroes(query = it) },
                onCloseClicked = { navController.popBackStack() }
            )
        },
        content = {
            ListContent(items = searchedImages)
        }
    )
}