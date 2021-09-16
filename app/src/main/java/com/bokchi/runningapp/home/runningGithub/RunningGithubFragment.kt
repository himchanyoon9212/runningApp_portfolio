package com.bokchi.runningapp.home.runningGithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.R
import com.bokchi.runningapp.network.github.repository.GithubRepository


class RunningGithubFragment : Fragment() {

    private lateinit var runningGithubViewModel: RunningGithubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_running_github, container, false)

        val repository = GithubRepository()
        val githubViewModelFactory = RunningGithubViewModelFactory(repository)
        runningGithubViewModel = ViewModelProvider(this, githubViewModelFactory).get(RunningGithubViewModel::class.java)

        runningGithubViewModel.getGithubData()


        return view
    }


    override fun onPause() {

        super.onPause()

    }


}