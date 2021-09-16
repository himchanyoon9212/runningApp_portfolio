package com.bokchi.runningapp.network.weather.weather.repository

import com.bokchi.runningapp.network.weather.weather.api.RetrofitInstance
import com.bokchi.runningapp.network.weather.weather.model.WeatherList
import retrofit2.Response

class Repository {

    suspend fun getWeatherData(query : String, appId : String) : Response<WeatherList> {

        return RetrofitInstance.api.getWeatherData(query, appId)

    }

}