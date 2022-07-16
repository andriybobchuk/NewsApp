package com.andriybobchuk.newsapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.andriybobchuk.newsapp.Constants

@Composable
fun TopNews(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Top News", fontWeight = FontWeight.SemiBold)
        Button(onClick = { 
            navController.navigate(Constants.DETAIL_ROUTE)
        }) {
            Text(text = "Go to detail screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopNewsPreview() {
    // It's just the default preview so we aren't passing a real navController
    TopNews(rememberNavController())
}









