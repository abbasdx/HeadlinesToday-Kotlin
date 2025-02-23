package com.example.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.Source
import com.example.newsapp.presentation.NewsAppViewModel
import com.example.newsapp.presentation.navigation.routes.CategoryScreen
import com.example.newsapp.presentation.navigation.routes.HomeScreen
import com.example.newsapp.presentation.screen.CategoryDetailUI
import com.example.newsapp.presentation.screen.HomeScreenUI


@Composable
fun AppNavigation(modifier: Modifier = Modifier, viewModel: NewsAppViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreenUI(navController = navController, viewModel = viewModel)
        }
        composable<CategoryScreen> {
            val categoryScreen = it.toRoute<CategoryScreen>()
            val article = Article(
                author = categoryScreen.author,
                content = categoryScreen.content,
                description = categoryScreen.description,
                publishedAt = categoryScreen.publishedAt,
                source = Source(
                    id = categoryScreen.id,
                    name = categoryScreen.name
                ),
                title = categoryScreen.title,
                url = categoryScreen.url,
                urlToImage = categoryScreen.urlToImage
            )
            CategoryDetailUI(
                article = article,
                navController = navController
            )
        }
    }
}
