package com.yoochangwonspro.timealarmproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("Not yet implemented")
    }

    private fun initNotificationCreateChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )

            NotificationManagerCompat.from(context).createNotificationChannel(mChannel)
        }
    }

    private fun initCreateNotification(context: Context) {
        with(NotificationManagerCompat.from(context)) {
            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("알람")
                .setContentText("일어날 시간입니다.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)

            notify(, builder.build())
        }
    }

    companion object {
        private const val CHANNEL_NAME = "Alarm Channel"
        private const val CHANNEL_ID = "AlarmChannelID"
        private const val NOTIFICATION_ID = 100
    }
}