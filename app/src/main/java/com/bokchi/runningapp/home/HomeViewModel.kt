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
import kotlinx.coroutines.withContext
import retrofit2.Response

class HomeViewModel(private val repository: Repository) : ViewModel(){

    private val TAG = HomeViewModel::class.java.simpleName

    var weatherResponse: MutableLiveData<Response<WeatherList>> = MutableLiveData()
    var timeCounter :MutableLiveData<Int> = MutableLiveData()

    lateinit var timerRoutine : Job

    var timerCoroutineFlag = true

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

    fun startTimer() : String{

        var startNumber = 0

        if (timeCounter.value != 0) {
            startNumber = timeCounter.value!!
        }

        if(timerCoroutineFlag) {

            timerRoutine = viewModelScope.launch {

                while (true) {
                    startNumber += 1
                    timeCounter.value = startNumber
                    delay(1000L)
                }
            }

            timerCoroutineFlag = false
            return "실행되었습니다."

        }

        return "이미 실행되어 있습니다."


    }

    fun tempStropTimer(){

        if(::timerRoutine.isInitialized) {
            timerRoutine.cancel()
            timerCoroutineFlag = true
        }
    }

    fun stopTimer(){

        if(::timerRoutine.isInitialized) {
            timerRoutine.cancel()
            timeCounter.value = 0
            timerCoroutineFlag = true
        }
    }



}