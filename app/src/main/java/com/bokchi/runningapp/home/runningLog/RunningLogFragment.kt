package com.bokchi.runningapp.home.runningLog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.FragmentRunningLogBinding
import com.bokchi.runningapp.db.runnginLogDB.RunningLogEntity
import com.bokchi.runningapp.home.HomeActivity

class RunningLogFragment : Fragment() {

    private val TAG = RunningLogFragment::class.java.simpleName

    private lateinit var binding : FragmentRunningLogBinding

    private lateinit var runningLogViewModel: RunningLogViewModel

    lateinit var runningLogRVAdapter: RunningLogRVAdapter
    lateinit var logList : ArrayList<RunningLogEntity>

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

        // init Data load
        runningLogViewModel.loadRecords()

        binding.removeBtn.setOnClickListener {
            runningLogViewModel.removeRecords()
        }

        runningLogViewModel.userData.observe(viewLifecycleOwner, Observer {

            runningLogRVAdapter.logList = it as ArrayList<RunningLogEntity>
            runningLogRVAdapter.notifyDataSetChanged()


        })

        initBottomTap()
        initRV()

        return binding.root
    }

    override fun onPause() {
        super.onPause()

    }

    private fun initBottomTap(){

        binding.bottomLayout.mainBottomTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_runningLogFragment_to_runningActionFragment)
        }


        binding.bottomLayout.githubBottomTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_runningLogFragment_to_runningGithubFragment)
        }

    }

    private fun initRV(){

        binding.logRv.apply {

            layoutManager = LinearLayoutManager(context)
            runningLogRVAdapter = RunningLogRVAdapter()
            adapter = runningLogRVAdapter

        }

    }


}