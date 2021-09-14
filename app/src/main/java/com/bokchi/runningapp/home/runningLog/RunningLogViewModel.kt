package com.bokchi.runningapp.home.runningLog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bokchi.runningapp.db.runnginLogDB.RoomRepository
import com.bokchi.runningapp.db.runnginLogDB.RunningLogEntity
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