package com.bokchi.runningapp.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bokchi.runningapp.utils.Constants
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class SplashViewModel : ViewModel() {

    private val TAG = SplashViewModel::class.java.simpleName

    init {

    }

    fun getUid() : String? {

        val uid = Firebase.auth.currentUser?.uid
        return uid

    }

}