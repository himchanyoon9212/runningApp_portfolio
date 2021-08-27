package com.bokchi.runningapp.splash

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.auth.IntroActivity
import com.bokchi.runningapp.home.HomeActivity
import com.bokchi.runningapp.utils.Constants

class SplashActivity : AppCompatActivity() {

    private val TAG = SplashActivity::class.java.simpleName
    private lateinit var splashViewModel: SplashViewModel

    private val isUidExist = 1
    private val isUidNull = 2

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        val uid = splashViewModel.getUid()

        if(uid == null) {
            checkUid(isUidNull)
        } else {
            checkUid(isUidExist)
            Constants.uid = uid

        }

    }

    private fun checkUid(uidNumber : Int){

        Handler(Looper.getMainLooper()).postDelayed({

            val intent : Intent

            if(uidNumber == isUidNull) {

                intent = Intent(this, IntroActivity::class.java)
            } else {

                intent = Intent(this, HomeActivity::class.java)
            }

            startActivity(intent)
            finish()

        }, 3000)



    }

}