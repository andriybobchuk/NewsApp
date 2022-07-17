package com.andriybobchuk.newsapp.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andriybobchuk.newsapp.BottomMenuScreen
import com.andriybobchuk.newsapp.Constants
import com.andriybobchuk.newsapp.MockData
import com.andriybobchuk.newsapp.components.BottomMenu
import com.andriybobchuk.newsapp.ui.screen.Categories
import com.andriybobchuk.newsapp.ui.screen.DetailScreen
import com.andriybobchuk.newsapp.ui.screen.Sources
import com.andriybobchuk.newsapp.ui.screen.TopNews

@Composable
fun NewsApp() {

    MainScreen(
        navController = rememberNavController(),
        scrollState = rememberScrollState()
    )
}

@Composable
fun MainScreen(navController: NavHostController, scrollState: ScrollState) {
    Scaffold(bottomBar = {

        BottomMenu(navController = navController)

    }) {
        Navigation(navController, scrollState)
    }
}


@Composable
fun Navigation(navController: NavHostController, scrollState: ScrollState) {

    NavHost(navController = navController, startDestination = Constants.TOP_NEWS_ROUTE) {

        bottomNavigation(navController)

        composable(Constants.TOP_NEWS_ROUTE) {
            TopNews(navController = navController)
        }
        composable(
            "${Constants.DETAIL_ROUTE}/{newsId}",
                arguments = listOf(navArgument("newsId") {type = NavType.IntType})
        ) {
            navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("newsId")
            DetailScreen(MockData.getNews(id), scrollState, navController)
        }
    }

}

fun NavGraphBuilder.bottomNavigation(navController: NavController) {
    composable(BottomMenuScreen.TopNews.route) {
        TopNews(navController = navController)
    }
    composable(BottomMenuScreen.Categories.route) {
        Categories()
    }
    composable(BottomMenuScreen.Sources.route) {
        Sources()
    }
}