package com.bokchi.runningapp.home.dialog

import android.content.Intent
import android.os.Bundle
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
import com.bokchi.runningapp.home.foregroundService.TimerService
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_RUN
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_STOP
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_TEMP_STOP

class TimerDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentTimerDialogBinding

    private lateinit var timerDialogViewModel: TimerDialogViewModel
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
        timerDialogViewModel = ViewModelProvider(activity as HomeActivity).get(TimerDialogViewModel::class.java)

        binding.dialogYesBtn.setOnClickListener {

            dismiss()

            when (arguments?.getString("TIMER_TYPE")) {
                TIMER_RUN -> {
                    homeViewModel.startTimer()
                    timerForegroundServiceHandler(TIMER_RUN)
                }
                TIMER_TEMP_STOP -> {

                    homeViewModel.tempStropTimer()
                    timerForegroundServiceHandler(TIMER_TEMP_STOP)

                }
                TIMER_STOP -> {

                    homeViewModel.stopTimer()
                    timerForegroundServiceHandler(TIMER_STOP)

                }
            }

        }

        binding.dialogNoBtn.setOnClickListener {
            dismiss()
        }

        homeViewModel = ViewModelProvider(activity as HomeActivity)[HomeViewModel::class.java]

        return binding.root

    }

    private fun timerForegroundServiceHandler(timerType : String){

        val intent = Intent(context, TimerService::class.java)
        intent.action = timerType
        (activity as HomeActivity).startService(intent)


    }


}