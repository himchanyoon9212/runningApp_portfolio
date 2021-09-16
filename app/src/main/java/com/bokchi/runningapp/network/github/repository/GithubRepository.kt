package com.bokchi.runningapp.network.github.repository

import com.bokchi.runningapp.network.github.api.RetrofitGithubInstance
import com.bokchi.runningapp.network.github.model.RecyclerList
import com.bokchi.runningapp.network.weather.weather.model.WeatherList
import retrofit2.Response

class GithubRepository {

    suspend fun getGithubData(query : String) : Response<RecyclerList> {

        return RetrofitGithubInstance.api.getDataFromAPI(query)

    }

}