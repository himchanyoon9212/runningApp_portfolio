package com.bokchi.runningapp.network.github.api

import com.bokchi.runningapp.network.github.model.RecyclerList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitGithubService {

    @GET("repositories")
    suspend fun getDataFromAPI(@Query("q") query: String): Response<RecyclerList>

}