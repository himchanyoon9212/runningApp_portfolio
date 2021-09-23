package com.bokchi.runningapp.utils

class Constants {

    companion object {

        // 437efd50dc7fdfdc2010de281414e0e8
        const val weatherApiKey = "TOKEN"
        const val BASE_WEATHER_URL = "https://api.openweathermap.org/data/2.5/"
        const val BASE_GITHUB_URL = "https://api.github.com/search/"
        lateinit var uid : String

        const val TIMER_RUN = "TIMER_RUN"
        const val TIMER_TEMP_STOP = "TIMER_TEMP_STOP"
        const val TIMER_STOP = "TIMER_STOP"

        const val TIMER_CHANNEL_ID = "timer_channel"
        const val TIMER_NOTIFICATION_ID = 1

        var TIMER_OFF_FLAG = "on"

    }


}