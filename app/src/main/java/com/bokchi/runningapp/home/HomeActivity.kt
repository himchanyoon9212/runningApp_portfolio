package com.bokchi.runningapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.ActivityHomeBinding
import com.bokchi.runningapp.network.weather.weather.repository.Repository
import com.bokchi.runningapp.utils.Constants.Companion.weatherApiKey
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val TAG = HomeActivity::class.java.simpleName

    private lateinit var binding : ActivityHomeBinding
    private lateinit var homeViewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val repository = Repository()
        val homeViewModelFactory = HomeViewModelFactory(repository)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        binding.homeViewModel = homeViewModel

        getWeatherData()
        checkForegroundServerStarted()

    }

    private fun getWeatherData(){

        // get Weather Data
        homeViewModel.getWeatherData("seoul", weatherApiKey)
        homeViewModel.weatherResponse.observe(this, Observer {

            binding.currentWeatherArea.text = it.body()?.weather?.get(0)?.main.toString()

        })

    }


    private fun checkForegroundServerStarted(){

        // 현재 foreground 데이터를 받아와서, timer 새롭게 시작
        if(intent.hasExtra("time")){

            Log.e(TAG, intent.getStringExtra("time").toString())
            homeViewModel.timeCounter.value = intent.getStringExtra("time")?.toInt()
            homeViewModel.startTimer()

        }

    }


}