package com.example.newsapp.presentation.screen

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.newsapp.R
import com.example.newsapp.data.model.Article

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun CategoryDetailUI(
    article: Article = Article(),
    navController: NavHostController
) {
    val date = article.publishedAt?.substring(0, 10)
    val time = article.publishedAt?.substring(11, 19)
    var showWebView by remember { mutableStateOf(false) }
    if (showWebView) {
        // WebView to show full article
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = object : WebViewClient() {}
                    loadUrl(article.url ?: "https://www.google.com") // Default URL
                }
            }
        )
    } else {
        // Article details view
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 9.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row (
                modifier = Modifier.fillMaxWidth().padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "Article Details",
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold
                )
            }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.SemiBold,
                    text = article.title ?: "No Title",
                    style = TextStyle(fontSize = 22.sp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,
                    model = article.urlToImage,
                    contentDescription = "News Image",
                    placeholder = painterResource(R.drawable.loading),
                )


                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Published: ",
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "$date  $time")
                }
//                Spacer(modifier = Modifier.height(2.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Source: ", fontWeight = FontWeight.SemiBold)
                    Text(text = article.source?.name ?: "Unknown")
                }
//                Spacer(modifier = Modifier.height(2.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Author: ", fontWeight = FontWeight.SemiBold)
                    Text(text = article.author ?: "Unknown")
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Description: ",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = article.description ?: "No description available.",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { showWebView = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCE0000))
                ) {
                    Text(text = "Read Full Article", color = Color.White)
                }
            }
        }
    }