package com.util.extensions

import android.content.Context
import android.os.CountDownTimer
import android.widget.TextView
import com.util.R
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun String.toDate(): Long {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault()).parse(this).time
}

fun String.calculateTime(context: Context, tvTime: TextView) {
    val date = this.toDate() - currentDate()
    if (date < 0) {
        tvTime.text = context.getString(R.string.campign_finished)
    } else {
        val timer = object : CountDownTimer(date, 1000) {
            override fun onFinish() {
                tvTime.text = context.getString(R.string.campign_finished)
            }

            override fun onTick(millisUntilFinished: Long) {
                var mDateText = ""
                val millis = millisUntilFinished
                val days = ((TimeUnit.MILLISECONDS.toDays(millis)).toString())
                val hours = ((TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(
                    TimeUnit.MILLISECONDS.toDays(millis)
                )).toString())
                val minutes = ((TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
                    TimeUnit.MILLISECONDS.toHours(millis)
                )).toString())
                val seconds =
                    ((TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millis)
                    )).toString())

                if (!days.equals("0")) {
                    mDateText = "$mDateText$days:Days"
                }
                if (!hours.equals("0")) {
                    mDateText = "$mDateText$hours:Hours"
                }
                if (!minutes.equals("0")) {
                    mDateText = "$mDateText$minutes:Minutes"
                }
                if (!seconds.equals("0")) {
                    mDateText = "$mDateText$seconds:Seconds"
                }
                tvTime.text = "$mDateText Remaining"
            }


        }
        timer.start()
    }

}

fun currentDate(): Long {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault()).format(Date()).toDate()
}