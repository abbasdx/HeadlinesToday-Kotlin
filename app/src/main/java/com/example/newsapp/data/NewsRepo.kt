package com.example.newsapp.data

import com.example.newsapp.data.apiBuilder.ApiBuilder
import com.example.newsapp.data.model.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
class NewsRepo {
    private val apiInstance = ApiBuilder.retrofitObject()

     fun getHeadline(country: String = "us"): Flow<ApiState> {
        return flow {
            emit(ApiState(loading = true))
            try {
                val response = apiInstance.getHeadlines(country = country)
                emit(ApiState(data = response))
            } catch (e: HttpException) {
                emit(ApiState(error = e.localizedMessage))

            } catch (e: Exception) {
                emit(ApiState(error = e.localizedMessage))
            }

        }
    }
    suspend fun getEverything(q: String = "India"): Flow<ApiState> {
        return flow {
            emit(ApiState(loading = true))
            try {
                val response = apiInstance.getEverything(q = q)
                emit(ApiState(data = response))
            } catch (e: HttpException) {
                emit(ApiState(error = e.localizedMessage))
            } catch (e: Exception) {
                emit(ApiState(error = e.localizedMessage))
            }
        }
    }


}

data class ApiState(
    var loading: Boolean? = false,
    var error:String? ="",
    var data: ApiResponse?= null

)