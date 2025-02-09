package com.example.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.NewsAppViewModel
import com.example.newsapp.presentation.navigation.routes.CategoryScreen
import com.example.newsapp.presentation.navigation.routes.HomeScreen
import com.example.newsapp.presentation.navigation.routes.SearchScreen
import com.example.newsapp.presentation.screen.CategoryDetailUI
import com.example.newsapp.presentation.screen.HomeScreenUI
import com.example.newsapp.presentation.screen.SearchScreenUI


@Composable
fun AppNavigation(modifier: Modifier = Modifier,viewModel: NewsAppViewModel) {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = HomeScreen){
       composable<HomeScreen>{
           HomeScreenUI(navController=navController,viewModel=viewModel)
       }
        composable<CategoryScreen>{
            CategoryDetailUI(
                navController = navController
            )
        }
        composable<SearchScreen>{
            SearchScreenUI(navController = navController, viewModel = viewModel)

        }
    }
}