package com.bokchi.runningapp.home.foregroundService

import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService
import com.bokchi.runningapp.home.dialog.TimerNotification
import com.bokchi.runningapp.utils.Constants
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_NOTIFICATION_ID
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_OFF_FLAG
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_RUN
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_TEMP_STOP
import kotlinx.coroutines.delay
import java.lang.Exception
import java.sql.Time
import java.util.*
import kotlin.concurrent.timer

class TimerService : LifecycleService() {

    private val TAG = TimerService::class.java.simpleName
    private var t_timer = Timer()
    private var int_count = 1

    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){
            TIMER_RUN ->{
                intent.getStringExtra("currentTimerText")?.let {
                    startForegroundService(it)
                }
            }
            TIMER_TEMP_STOP->{
                tempStopForegroundService()
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

        TIMER_OFF_FLAG = "on"
        // schedule

        try {
            t_timer.schedule(object : TimerTask(){
                override fun run(){

                    //카운트 값 증가
                    int_count ++

                    val notification = TimerNotification.createNotification(application, int_count.toString(), TIMER_OFF_FLAG)
                    startForeground(TIMER_NOTIFICATION_ID, notification)
                }
            },1000, 1000)
        } catch (e : Exception) {
            t_timer = Timer()
            t_timer.schedule(object : TimerTask(){
                override fun run(){

                    //카운트 값 증가
                    int_count ++

                    val notification = TimerNotification.createNotification(application, int_count.toString(), TIMER_OFF_FLAG)
                    startForeground(TIMER_NOTIFICATION_ID, notification)
                }
            },1000, 1000)

        }

    }

    private fun tempStopForegroundService(){

        t_timer.cancel()

        TIMER_OFF_FLAG = "off"

        val notification = TimerNotification.createNotification(application, int_count.toString(), TIMER_OFF_FLAG)
        startForeground(TIMER_NOTIFICATION_ID, notification)


    }

    private fun stopForegroundService(){

        stopForeground(true)
        stopSelf()

    }




}