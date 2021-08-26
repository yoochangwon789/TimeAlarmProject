package com.yoochangwonspro.timealarmproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("Not yet implemented")
    }

    private fun initNotificationCreateChannel() {
    }

    private fun initCreateNotification() {

    }

    companion object {
        private const val CHANNEL_NAME = "Alarm Channel"
        private const val CHANNEL_ID = "AlarmChannelID"
    }
}