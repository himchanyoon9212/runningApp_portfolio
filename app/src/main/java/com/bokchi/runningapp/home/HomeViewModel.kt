package com.bokchi.runningapp.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bokchi.runningapp.network.model.WeatherList
import com.bokchi.runningapp.network.repository.Repository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository) : ViewModel(){

    private val TAG = HomeViewModel::class.java.simpleName

    var weatherResponse: MutableLiveData<Response<WeatherList>> = MutableLiveData()
    var timeCounter :MutableLiveData<Int> = MutableLiveData()

    lateinit var timerRoutine : Job

    init {
        timeCounter.value = 0
    }

    fun getWeatherData(city : String, token : String) {

        viewModelScope.launch {
            val response = repository.getWeatherData(city,token)
            if(response.code() == 200) {
                weatherResponse.value = response
            }
        }

    }

    fun startTimer() {

        var startNumber = 0

        if (timeCounter.value != 0) {
            startNumber = timeCounter.value!!
        }

        // 처음 시작할 때
        timerRoutine = viewModelScope.launch {

            while (true) {
                startNumber += 1
                timeCounter.value = startNumber
                delay(1000L)
            }
        }

    }

    fun tempStropTimer(){

        if(::timerRoutine.isInitialized) {
            timerRoutine.cancel()
        }
    }

    fun stopTimer(){

        if(::timerRoutine.isInitialized) {
            timerRoutine.cancel()
            timeCounter.value = 0
        }
    }



}