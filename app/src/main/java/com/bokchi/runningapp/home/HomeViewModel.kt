package com.bokchi.runningapp.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bokchi.runningapp.network.model.WeatherList
import com.bokchi.runningapp.network.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository) : ViewModel(){

    private val TAG = HomeViewModel::class.java.simpleName

    var weatherResponse: MutableLiveData<Response<WeatherList>> = MutableLiveData()

    fun getWeatherData(city : String, token : String) {

        // 예외처리 해줘야함 response code를 받아와야함
        viewModelScope.launch {
            val response = repository.getWeatherData(city,token)
            weatherResponse.value = response
        }


    }
}