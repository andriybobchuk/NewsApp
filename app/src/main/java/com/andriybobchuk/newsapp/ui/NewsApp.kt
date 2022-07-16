package com.andriybobchuk.newsapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.andriybobchuk.newsapp.Constants
import com.andriybobchuk.newsapp.MockData
import com.andriybobchuk.newsapp.ui.screen.DetailScreen
import com.andriybobchuk.newsapp.ui.screen.TopNews

@Composable
fun NewsApp() {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Constants.TOP_NEWS_ROUTE) {
        composable(Constants.TOP_NEWS_ROUTE) {
            TopNews(navController = navController)
        }
        composable(
            "${Constants.DETAIL_ROUTE}/{newsId}",
                arguments = listOf(navArgument("newsId") {type = NavType.IntType})
        ) {
            navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("newsId")
            DetailScreen(navController = navController, MockData.getNews(id))
        }
    }

}