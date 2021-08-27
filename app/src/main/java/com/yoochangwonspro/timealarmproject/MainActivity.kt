package com.yoochangwonspro.timealarmproject

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val timeTextView: TextView by lazy {
        findViewById(R.id.time_text_view)
    }

    private val amPmTextView: TextView by lazy {
        findViewById(R.id.am_pm_text_view)
    }

    private val alarmChangeButton: Button by lazy {
        findViewById(R.id.alarm_time_change_btn)
    }

    private val alarmOnOffButton: Button by lazy {
        findViewById(R.id.alarm_on_off_btn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAlarmChangeButton()
    }

    private fun initAlarmChangeButton() {
        alarmChangeButton.setOnClickListener {

            val calendar = Calendar.getInstance()

            TimePickerDialog(this, { _, hour, minute ->
                val model = alarmSaveData(hour, minute, false)

                renderView(model)
                alarmPendingIntentCancel()

            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false)
                .show()
        }
    }

    private fun renderView(model: AlarmModel) {
        timeTextView.text = model.timeText
        amPmTextView.text = model.timeAmPm
    }

    @SuppressLint("CommitPrefEdits")
    private fun alarmSaveData(
        hour: Int,
        minute: Int,
        onOff: Boolean,
    ): AlarmModel {
        val model = AlarmModel(
            hour = hour,
            minute = minute,
            onOff = onOff
        )

        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        with(sharedPreferences.edit()) {
            putString(SHARED_PREFERENCES_TIME_KEY, model.timeData)
            putBoolean(SHARED_PREFERENCES_ON_OFF_KEY, model.onOff)
            commit()
        }

        return model
    }

    private fun alarmPendingIntentCancel() {
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            PENDING_INTENT_REQUEST_CODE,
            Intent(this, AlarmReceiver::class.java),
            PendingIntent.FLAG_NO_CREATE
        )
        pendingIntent.cancel()
    }

    companion object {
        private const val SHARED_PREFERENCES_NAME = "time"
        private const val SHARED_PREFERENCES_TIME_KEY = "time_key"
        private const val SHARED_PREFERENCES_ON_OFF_KEY = "onOff_key"
        private const val PENDING_INTENT_REQUEST_CODE = 100
    }
}