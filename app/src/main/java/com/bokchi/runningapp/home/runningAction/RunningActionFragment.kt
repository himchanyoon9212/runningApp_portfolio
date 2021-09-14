package com.bokchi.runningapp.home.runningAction

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.FragmentRunningActionBinding
import com.bokchi.runningapp.home.HomeActivity
import com.bokchi.runningapp.home.HomeViewModel
import com.bokchi.runningapp.home.dialog.TimerDialogFragment
import com.bokchi.runningapp.home.foregroundService.TimerService
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_RUN
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_STOP
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_TEMP_STOP

class RunningActionFragment : Fragment() {

    private val TAG = RunningActionFragment::class.java.simpleName

    private lateinit var binding : FragmentRunningActionBinding
    private lateinit var homeViewModel : HomeViewModel

    private lateinit var timeDialog : TimerDialogFragment

    private lateinit var dialogArgs : Bundle

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
            dialog(TIMER_RUN)
        }

        binding.tempStopBtn.setOnClickListener {
            dialog(TIMER_TEMP_STOP)
        }

        binding.stopBtn.setOnClickListener {
            dialog(TIMER_STOP)
        }

        homeViewModel.timeCounter.observe(viewLifecycleOwner, Observer {

            val currentTimerText = homeViewModel.timeCounter.value.toString()
            binding.timeCounterShowArea.text = currentTimerText


        })

        initBottomTap()

        return binding.root

    }

    override fun onPause() {
        super.onPause()


    }


    private fun initBottomTap(){

        binding.bottomLayout.logBottomTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_runningActionFragment_to_runningLogFragment)
        }

    }

    private fun dialog(category : String){

        dialogArgs = Bundle().apply {
            putString("TIMER_TYPE", category)
        }

        timeDialog = TimerDialogFragment()
        timeDialog.arguments = dialogArgs
        timeDialog.show((activity as HomeActivity).supportFragmentManager, "")

    }


}