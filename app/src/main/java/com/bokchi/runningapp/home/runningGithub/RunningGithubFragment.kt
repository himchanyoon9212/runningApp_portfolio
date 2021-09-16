package com.bokchi.runningapp.home.runningGithub

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bokchi.runningapp.R
import com.bokchi.runningapp.databinding.FragmentRunningGithubBinding
import com.bokchi.runningapp.network.github.repository.GithubRepository


class RunningGithubFragment : Fragment() {

    private val TAG = RunningGithubFragment::class.java.simpleName

    private lateinit var binding : FragmentRunningGithubBinding

    private lateinit var runningGithubViewModel: RunningGithubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_running_github, container, false)

        val repository = GithubRepository()
        val githubViewModelFactory = RunningGithubViewModelFactory(repository)
        runningGithubViewModel = ViewModelProvider(this, githubViewModelFactory).get(RunningGithubViewModel::class.java)


        getGithubData()

        return binding.root
    }


    override fun onPause() {

        super.onPause()

    }


    private fun getGithubData(){

        runningGithubViewModel.getGithubData()
        runningGithubViewModel.githubResponse.observe(viewLifecycleOwner, Observer {

            Log.e(TAG, it.body()?.items.toString())

        })


        initBottomTap()

    }


    private fun initBottomTap(){

        binding.bottomLayout.mainBottomTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_runningGithubFragment_to_runningActionFragment)
        }

        binding.bottomLayout.logBottomTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_runningGithubFragment_to_runningLogFragment)
        }

    }



}