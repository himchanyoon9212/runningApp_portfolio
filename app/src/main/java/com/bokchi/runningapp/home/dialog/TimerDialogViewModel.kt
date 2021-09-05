package com.bokchi.runningapp.home.dialog

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bokchi.runningapp.db.RoomRepository
import com.bokchi.runningapp.db.RunningLogEntity
import com.bokchi.runningapp.utils.Constants
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_RUN
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_STOP
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_TEMP_STOP
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimerDialogViewModel @Inject constructor(private val repository: RoomRepository): ViewModel() {

    private val TAG = TimerDialogViewModel::class.java.simpleName

    fun insertRecord(runningLogEntity: RunningLogEntity) {

        Log.e(TAG, "insertRecode")
        repository.insertRecord(runningLogEntity)

    }



}