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
fun DetailScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Detail Screen", fontWeight = FontWeight.SemiBold)
        Button(onClick = {
            // Instead of:
            // **navController.navigate(Constants.TOP_NEWS_ROUTE)**
            // Use:
            navController.popBackStack()
            // Not to stack screens as the user navigates
        }) {
            Text(text = "Go to back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    // It's just the default preview so we aren't passing a real navController
    DetailScreen(rememberNavController())
}