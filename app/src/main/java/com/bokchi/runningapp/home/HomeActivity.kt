package com.bokchi.runningapp.home

import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.ActivityHomeBinding
import com.bokchi.runningapp.network.repository.Repository
import com.bokchi.runningapp.utils.Constants.Companion.weatherApiKey
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var homeViewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val repository = Repository()
        val homeViewModelFactory = HomeViewModelFactory(repository)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        binding.homeViewModel = homeViewModel


        homeViewModel.getWeatherData("seoul", weatherApiKey)
        homeViewModel.weatherResponse.observe(this, Observer {

            binding.currentWeatherArea.text = it.body()?.weather?.get(0)?.main.toString()

        })

    }


}