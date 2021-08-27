package com.yoochangwonspro.timealarmproject

data class AlarmModel(
    val hour: Int,
    val minute: Int,
    var onOff: Boolean
) {
    val timeText: String
        get() {
            val h = "%02d".format(if (hour > 12) hour - 12 else hour)
            val m = "%02d".format(minute)

            return "$h:$m"
        }

    val timeAmPm: String
        get() {
            return if (hour < 12) "AM" else "PM"
        }

    val onOffText: String
        get() {
            return if (onOff) "알람 끄기" else "알람 켜기"
        }

    fun timeData(): String {
        return "$hour:$minute"
    }

}