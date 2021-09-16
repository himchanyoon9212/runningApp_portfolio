package com.bokchi.runningapp.network.weather.weather.model

data class WeatherList (
    val weather: ArrayList<WeatherData>
)

data class WeatherData(
    val main : String
)