package com.bokchi.runningapp.network.github.api

import com.bokchi.runningapp.network.weather.weather.api.RetrofitService
import com.bokchi.runningapp.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGithubInstance {

    companion object {

        fun getRetrofitGithubInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

        val api = getRetrofitGithubInstance().create(RetrofitGithubService::class.java)

    }


}