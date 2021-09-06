package com.bokchi.runningapp.home.runningLog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bokchi.runningapp.db.RoomRepository
import com.bokchi.runningapp.db.RunningLogEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RunningLogViewModel @Inject constructor(private val repository: RoomRepository): ViewModel() {

    private val TAG = RunningLogViewModel::class.java.simpleName

    var userData: MutableLiveData<List<RunningLogEntity>> = MutableLiveData()

    init {
        loadRecords()
    }

    fun loadRecords(){

        val logList = repository.getRecords()
        userData.postValue(logList)

    }

    fun removeRecords(){
        repository.removeRecords()
    }


}