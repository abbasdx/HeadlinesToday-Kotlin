package com.example.newsapp.presentation.screen

import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.Source

//@PreviewScreenSizes
//@PreviewLightDark
//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailUI(
    modifier: Modifier = Modifier,
    article: Article = Article(
        source = Source(
            id = "nbc-news",
            name = "NBC News"
        ),
        author = "Katherine Doyle, Raquel Coronell Uribe, Megan Lebowitz",
        title = "Russell Vought, CFPB's new acting head, issues directives to halt portions of bureau activity - NBC News",
        description = "Office of Management and Budget Director Russell Vought issued a series of directives to Consumer Financial Protection Bureau employees Saturday night in his new capacity a the bureau's acting head, effectively slowing a large portion of the bureau's activity…",
        url = "https://www.nbcnews.com/politics/doge/russell-vought-consumer-financial-protection-bureau-trump-rcna191356",
        urlToImage = "https://media-cldnry.s-nbcnews.com/image/upload/t_nbcnews-fp-1200-630,f_auto,q_auto:best/rockcms/2025-02/250208-russell-vought-wm-335p-ad2715.jpg",
        publishedAt = "2025-02-09T01:19:00Z",
        content = "Office of Management and Budget Director Russell Vought issued a series of directives to Consumer Financial Protection Bureau employees Saturday night in his new capacity a the bureau's acting head, … [+4247 chars]"
    ),
    navController: NavHostController
){

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                loadUrl(article.url.toString())
            }
        }
    )
//    Scaffold (
//        modifier = Modifier.fillMaxSize(),
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "News App")
//                }
//            )
//        }
//    ){
//        Column(
//            modifier = Modifier.fillMaxWidth().padding(it),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Text(
//                text = article.title.toString(),
//                style = TextStyle(
//                    fontSize = 25.sp
//                )
//            )
//            AsyncImage(
//                model = article.urlToImage,
//                contentDescription = null
//            )
//        }
//    }
}