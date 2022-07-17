package com.andriybobchuk.newsapp

/**
 * I am using object instead of companion object for global constants.
 *
 * Here is a reason:
 * https://stackoverflow.com/a/50520935/17481213
 */

object Constants {

    // NewsApp.kt - Navigation Routes
    const val TOP_NEWS_ROUTE = "TopNews"
    const val DETAIL_ROUTE = "Detail"
    const val CATEGORIES_ROUTE = "Categories"
    const val SOURCES_ROUTE = "Sources"
}