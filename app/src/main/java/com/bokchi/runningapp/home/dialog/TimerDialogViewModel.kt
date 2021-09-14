package com.bokchi.runningapp.home.dialog

import androidx.lifecycle.ViewModel
import com.bokchi.runningapp.db.runnginLogDB.RoomRepository
import com.bokchi.runningapp.db.runnginLogDB.RunningLogEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimerDialogViewModel @Inject constructor(private val repository: RoomRepository): ViewModel() {

    private val TAG = TimerDialogViewModel::class.java.simpleName

    fun insertRecord(runningLogEntity: RunningLogEntity) {

        repository.insertRecord(runningLogEntity)

    }

}