package com.bokchi.runningapp.home.foregroundService

import android.content.Intent
import android.os.IBinder
import androidx.lifecycle.LifecycleService
import com.bokchi.runningapp.home.dialog.TimerNotification
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_NOTIFICATION_ID
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_RUN

class TimerService : LifecycleService() {

    private val TAG = TimerService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){
            TIMER_RUN ->{
                intent.getStringExtra("currentTimerText")?.let { startForegroundService(it) }
            }
            else ->{
                stopForegroundService()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        super.onBind(intent)

        return null
    }


    private fun startForegroundService(time : String){

        val notification = TimerNotification.createNotification(this, time)
        startForeground(TIMER_NOTIFICATION_ID, notification)

    }

    private fun tempStopForegroundService(){

    }

    private fun stopForegroundService(){

        stopForeground(true)
        stopSelf()

    }


}