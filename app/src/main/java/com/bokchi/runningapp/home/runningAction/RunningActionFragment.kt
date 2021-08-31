package com.bokchi.runningapp.home.runningAction

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.FragmentRunningActionBinding
import com.bokchi.runningapp.home.HomeActivity
import com.bokchi.runningapp.home.HomeViewModel


class RunningActionFragment : Fragment() {

    private val TAG = RunningActionFragment::class.java.simpleName

    private lateinit var binding : FragmentRunningActionBinding
    private lateinit var homeViewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_running_action, container, false)

        homeViewModel = ViewModelProvider(activity as HomeActivity)[HomeViewModel::class.java]


        binding.startBtn.setOnClickListener {
            homeViewModel.startTimer()
        }

        binding.tempStopBtn.setOnClickListener {
            homeViewModel.tempStropTimer()
        }

        binding.stopBtn.setOnClickListener {
            homeViewModel.stopTimer()
        }

        homeViewModel.timeCounter.observe(viewLifecycleOwner, Observer {
            binding.timeCounterShowArea.text = homeViewModel.timeCounter.value.toString()
        })

        return binding.root

    }

    override fun onPause() {
        super.onPause()
        // 기록 남겨주기

    }


}