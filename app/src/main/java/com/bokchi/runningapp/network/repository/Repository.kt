package com.bokchi.runningapp.network.repository

import com.bokchi.runningapp.network.api.RetrofitInstance
import com.bokchi.runningapp.network.model.WeatherData
import com.bokchi.runningapp.network.model.WeatherList
import retrofit2.Response

class Repository {

    suspend fun getWeatherData(a : String, b : String) : Response<WeatherList> {

        return RetrofitInstance.api.getWeatherData(a, b)
    }

    fun test(){

    }

}