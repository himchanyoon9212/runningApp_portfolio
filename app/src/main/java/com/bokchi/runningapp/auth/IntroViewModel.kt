package com.bokchi.runningapp.auth

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bokchi.runningapp.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.currentCoroutineContext
import java.lang.Exception
import java.lang.NullPointerException
import kotlin.coroutines.coroutineContext

class IntroViewModel : ViewModel(){

    private val TAG = IntroViewModel::class.java.simpleName

    var email : String = ""
    var password : String = ""

    var result = MutableLiveData<String>()

    fun createUser( email : String, pwd : String) {

        val auth = Firebase.auth

        // Null Exception Check
        try {

            auth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener {

                    result.value = "success"
                    Constants.uid = auth.currentUser!!.uid
                }
                .addOnFailureListener {

                    result.value = "fail"
                }

        } catch (e : Exception) {

            result.value = "exception"

        }




    }


}