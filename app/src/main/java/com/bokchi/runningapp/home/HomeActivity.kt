package com.bokchi.runningapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.ActivityHomeBinding
import com.bokchi.runningapp.network.repository.Repository
import com.bokchi.runningapp.utils.Constants.Companion.weatherApiKey

class HomeActivity : AppCompatActivity() {

    private val TAG = HomeActivity::class.java.simpleName

    private lateinit var binding : ActivityHomeBinding
    private lateinit var homeViewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)


        val repository = Repository()
        val hoemViewModelFactory = HomeViewModelFactory(repository)
        homeViewModel = ViewModelProvider(this, hoemViewModelFactory).get(HomeViewModel::class.java)
        binding.homeViewModel = homeViewModel

        homeViewModel.getWeatherData("seoul", weatherApiKey)
        homeViewModel.weatherResponse.observe(this, Observer {

            binding.currentWeatherArea.text = it.body()?.weather?.get(0)?.main.toString()


        })



    }


}