package com.bokchi.runningapp.home.dialog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.FragmentTimerDialogBinding
import com.bokchi.runningapp.home.HomeActivity
import com.bokchi.runningapp.home.HomeViewModel

class TimerDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentTimerDialogBinding
    private lateinit var homeViewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timer_dialog, container, false)
        homeViewModel = ViewModelProvider(activity as HomeActivity)[HomeViewModel::class.java]

        binding.dialogYesBtn.setOnClickListener {

            dismiss()

            when (arguments?.getInt("TIMER_TYPE")) {
                1 -> {
                    homeViewModel.startTimer()
                }
                2 -> {
                    homeViewModel.tempStropTimer()
                }
                3 -> {
                    homeViewModel.stopTimer()
                }
            }

        }

        binding.dialogNoBtn.setOnClickListener {
            dismiss()
        }

        homeViewModel = ViewModelProvider(activity as HomeActivity)[HomeViewModel::class.java]

        return binding.root
    }


}