package com.bokchi.runningapp.network.weather.weather.api

import com.bokchi.runningapp.utils.Constants.Companion.BASE_WEATHER_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {

        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(BASE_WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }



        val api = getRetrofitInstance().create(RetrofitService::class.java)

    }


}