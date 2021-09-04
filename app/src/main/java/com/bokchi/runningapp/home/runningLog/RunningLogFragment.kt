package com.bokchi.runningapp.home.runningLog

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
import com.bokchi.runningapp.databinding.FragmentRunningLogBinding
import com.bokchi.runningapp.db.RunningLogEntity
import com.bokchi.runningapp.home.HomeActivity
import com.bokchi.runningapp.home.HomeViewModel
import com.bokchi.runningapp.home.dialog.TimerDialogViewModel

class RunningLogFragment : Fragment() {


    private val TAG = RunningLogFragment::class.java.simpleName

    private lateinit var binding : FragmentRunningLogBinding

    private lateinit var runningLogViewModel: RunningLogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_running_log, container, false)
        runningLogViewModel = ViewModelProvider(activity as HomeActivity).get(RunningLogViewModel::class.java)


        binding.btn1.setOnClickListener {
            val userEntity = RunningLogEntity(log = "asdf")
            runningLogViewModel.insertRecord(userEntity)
        }

        binding.btn2.setOnClickListener {
            runningLogViewModel.loadRecords()
            runningLogViewModel.getRecordsObserver().observe(viewLifecycleOwner, Observer {
                for ( i in it) {
                    Log.e(TAG, i.log)
                }
            })
        }



        return binding.root
    }

    override fun onPause() {
        super.onPause()

    }

    private fun initVM(){


    }


}