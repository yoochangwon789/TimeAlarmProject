package com.yoochangwonspro.timealarmproject

data class AlarmModel(
    val hour: Int,
    val minute: Int,
    val onOff: Boolean
) {
    val timeAmPm: String
        get() {
            return if (hour < 12) "AM" else "PM"
        }
}