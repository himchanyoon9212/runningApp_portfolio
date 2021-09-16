package com.bokchi.runningapp.home.runningGithub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bokchi.runningapp.network.github.repository.GithubRepository

class RunningGithubViewModelFactory(private val repository : GithubRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RunningGithubViewModel(repository) as T
    }
}