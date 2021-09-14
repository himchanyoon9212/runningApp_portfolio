package com.bokchi.runningapp.home.dialog

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.FragmentTimerDialogBinding
import com.bokchi.runningapp.db.RunningLogEntity
import com.bokchi.runningapp.home.HomeActivity
import com.bokchi.runningapp.home.HomeViewModel
import com.bokchi.runningapp.home.foregroundService.TimerService
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_RUN
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_STOP
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_TEMP_STOP


class TimerDialogFragment : DialogFragment() {

    private val TAG = TimerDialogFragment::class.java.simpleName

    private lateinit var binding : FragmentTimerDialogBinding

    private lateinit var timerDialogViewModel: TimerDialogViewModel
    private lateinit var homeViewModel : HomeViewModel

    private lateinit var lastTimerCounter : String

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
        timerDialogViewModel = ViewModelProvider(activity as HomeActivity).get(TimerDialogViewModel::class.java)

        binding.dialogYesBtn.setOnClickListener {

            dismiss()

            when (arguments?.getString("TIMER_TYPE")) {
                TIMER_RUN -> {
                    homeViewModel.startTimer()
                    // Foreground가 떠 있으면 Foregournd 띄우지 않음
                    if(homeViewModel.timeCounter.value == 1) {
                        timerForegroundServiceHandler(TIMER_RUN)
                    }

                }
                TIMER_TEMP_STOP -> {

                    homeViewModel.tempStropTimer()
                    timerForegroundServiceHandler(TIMER_TEMP_STOP)

                }
                TIMER_STOP -> {

                    lastTimerCounter = homeViewModel.timeCounter.value.toString()
                    val runningEntity = RunningLogEntity(log = lastTimerCounter)
                    timerDialogViewModel.insertRecord(runningEntity)

                    homeViewModel.stopTimer()
                    timerForegroundServiceHandler(TIMER_STOP)

                }

            }

        }

        binding.dialogNoBtn.setOnClickListener {
            dismiss()
        }

        return binding.root

    }

    private fun timerForegroundServiceHandler(timerType : String){

        val intent = Intent(context, TimerService::class.java).apply {
            action = timerType
            putExtra("currentTimerText", "start")
        }
        (activity as HomeActivity).startService(intent)

    }



}