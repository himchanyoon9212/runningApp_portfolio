package com.bokchi.runningapp.home.dialog

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.bokchi.runningapp.R
import com.bokchi.runningapp.home.HomeActivity
import com.bokchi.runningapp.utils.Constants.Companion.TIMER_CHANNEL_ID

object TimerNotification {

    private val TAG = TimerNotification::class.java.simpleName

    fun createNotification(context: Context, time : String, on_off_flag : String): Notification {

        // 알림 클릭시 HomeActivity 로 이동
        val notificationIntent = Intent(context, HomeActivity::class.java)

        //notificationIntent에 현재 Count 전달
        notificationIntent.putExtra("time", time)
        notificationIntent.putExtra("onOff", on_off_flag)

        notificationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(context, TIMER_CHANNEL_ID)
            .setContentTitle("카운팅을 시작하였습니다.")
            .setContentText("counting : $time")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true)
            .setContentIntent(pendingIntent)
            .build()


        // VersionCheck
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                TIMER_CHANNEL_ID,
                "TIMER_CHANNEL_ID",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = context.getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }

        return notification
    }

}