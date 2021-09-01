package com.bokchi.runningapp.home.foregroundService

import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService
import com.bokchi.runningapp.home.dialog.TimerNotification
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_NOTIFICATION_ID
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_RUN
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_STOP
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_TEMP_STOP

class TimerService : LifecycleService() {

    private val TAG = TimerService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        Log.e(TAG, intent?.action.toString())

        when(intent?.action){
            TIMER_RUN ->{
                startForegroundService()
            }
            else ->{
                stopForegroundService()
            }
        }

        startForegroundService()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        super.onBind(intent)

        return null
    }


    private fun startForegroundService(){

        val notification = TimerNotification.createNotification(this)
        startForeground(TIMER_NOTIFICATION_ID, notification)


    }

    private fun tempStopForegroundService(){

    }

    private fun stopForegroundService(){

        stopForeground(true)
        stopSelf()

    }


}