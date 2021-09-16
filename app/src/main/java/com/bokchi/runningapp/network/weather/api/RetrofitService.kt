package com.bokchi.runningapp.network.weather.weather.api

import com.bokchi.runningapp.network.weather.weather.model.WeatherList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("weather")
    suspend fun getWeatherData(
        @Query("q") query: String,
        @Query("appid") query2: String
    ) : Response<WeatherList>


}