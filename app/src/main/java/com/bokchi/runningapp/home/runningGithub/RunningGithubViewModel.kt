package com.bokchi.runningapp.home.runningGithub

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bokchi.runningapp.network.github.model.RecyclerList
import com.bokchi.runningapp.network.github.repository.GithubRepository
import com.bokchi.runningapp.network.weather.weather.model.WeatherList
import kotlinx.coroutines.launch
import retrofit2.Response

class RunningGithubViewModel(private val repository: GithubRepository) : ViewModel() {

    private val TAG = RunningGithubViewModel::class.java.simpleName
    var githubResponse: MutableLiveData<Response<RecyclerList>> = MutableLiveData()

    fun getGithubData(){

        viewModelScope.launch {

            val response = repository.getGithubData("running")
            githubResponse.value = response

        }

    }

}