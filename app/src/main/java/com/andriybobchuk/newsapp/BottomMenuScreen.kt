package com.andriybobchuk.newsapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

// Sealed Classes allow fixing type hierarchies and forbid developers from creating new subclasses.
sealed class BottomMenuScreen(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object TopNews: BottomMenuScreen(Constants.TOP_NEWS_ROUTE, icon = Icons.Outlined.Home, "Top News")
    object Categories: BottomMenuScreen(Constants.CATEGORIES_ROUTE, icon = Icons.Outlined.Home, "Categories")
    object Sources: BottomMenuScreen(Constants.SOURCES_ROUTE, icon = Icons.Outlined.Home, "Sources")
}
