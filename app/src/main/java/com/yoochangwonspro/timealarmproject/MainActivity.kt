package com.yoochangwonspro.timealarmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
    }

    private fun alarmSaveData(
        hour: Int,
        minute: Int,
        onOff: Boolean
    ) : AlarmModel {
        val model = AlarmModel(hour, minute, onOff)

        val sharedPreferences = getSharedPreferences()
    }

    companion object {
        private const val SHARED_PREFERENCES_NAME = "time"
    }
}