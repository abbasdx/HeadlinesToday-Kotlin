package com.example.newsapp.data.apiService

import com.example.newsapp.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "YOUR_API_KEY"
    ): ApiResponse

    @GET("everything")
    suspend fun getEverything(
        @Query("q") q: String = "us",
        @Query("apiKey") apiKey: String = "YOUR_API_KEY"
    ): ApiResponse
}
