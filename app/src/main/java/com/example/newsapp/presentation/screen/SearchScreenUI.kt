package com.example.newsapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newsapp.presentation.NewsAppViewModel
import com.example.newsapp.presentation.navigation.routes.HomeScreen

@Composable
fun SearchScreenUI(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: NewsAppViewModel
) {
    val searchTerm = remember { mutableStateOf("") }
    OutlinedTextField(value = searchTerm.value,
        shape = RoundedCornerShape(15.dp),
        label = { Text(text = "Search") },
        placeholder = { Text(text = "Type, Tap, and Get the News...") },
        onValueChange = {
            searchTerm.value = it
        }, trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = "Search",
                modifier = Modifier.clickable(
                    enabled = searchTerm.value.isBlank().not(), onClick = {
                        viewModel.getEverything(q = searchTerm.value)
                        navController.navigate(HomeScreen)
                    })
            )
        },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 9.dp)
    )

}