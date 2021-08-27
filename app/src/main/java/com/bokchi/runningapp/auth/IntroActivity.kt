package com.bokchi.runningapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.ActivityIntroBinding
import com.bokchi.runningapp.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class IntroActivity : AppCompatActivity() {

    private val TAG = IntroActivity::class.java.simpleName

    private lateinit var binding : ActivityIntroBinding
    private lateinit var introViewModel : IntroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        introViewModel = ViewModelProvider(this).get(IntroViewModel::class.java)

        binding.joinBtn.setOnClickListener {

            Toast.makeText(this@IntroActivity, "회원가입을 시도합니다.", Toast.LENGTH_SHORT).show()

            introViewModel.email = binding.createuserEmailArea.text.toString()
            introViewModel.password = binding.createUserPasswordArea.text.toString()

            introViewModel.createUser(
                introViewModel.email,
                introViewModel.password
            )

            binding.createuserEmailArea.setText("")
            binding.createUserPasswordArea.setText("")

        }

        introViewModel.result.observe(this, Observer {

            Log.d(TAG, it.toString())

            val result = it.toString()

            when(result) {
                "exception" -> {
                    Toast.makeText(this@IntroActivity, "값을 넣어주세요.", Toast.LENGTH_SHORT).show()
                }
                "success" -> {
                    Toast.makeText(this@IntroActivity, "회원가입 완료", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@IntroActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                "fail" -> {
                    Toast.makeText(this@IntroActivity, "올바른 양식이 아닙니다.", Toast.LENGTH_SHORT).show()
                }

            }

        })

    }
}