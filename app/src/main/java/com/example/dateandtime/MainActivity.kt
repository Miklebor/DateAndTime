package com.example.dateandtime

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.time.LocalDate
import java.time.LocalDateTime.*
import java.time.LocalTime
import java.time.LocalTime.*
import java.time.Month.*
import java.time.temporal.ChronoUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)
        val setBtn = findViewById<ImageView>(R.id.imageView)

            var currentTime = LocalTime.now()
            var currentDate = LocalDate.now()
            var timeCh = LocalTime.of(23, 59, 59)
            var dateCh = LocalDate.of(2023, 12, 31)
            var periodDateDays: Long = (ChronoUnit.DAYS.between(currentDate, dateCh))*86400000
            var periodTime: Long = ChronoUnit.MILLIS.between(currentTime, timeCh)
            var timerVal: Long = (periodTime + periodDateDays) // + periodTime)

            cntDownTimer1(timerVal)

            setBtn.setOnClickListener() {
                val settingsIntent = Intent(this, Settings::class.java)
                println("* нажата setBtn *")
                startActivity(settingsIntent)
            }
    }
    private fun cntDownTimer1(timerVal: Long) {
        val txtView = findViewById<TextView>(R.id.textView)
        val txtView2 = findViewById<TextView>(R.id.textView2)
        var year: Long = 0
        var month: Long = 0
        var day: Long = 0
        var hour: Long = 0
        var min: Long = 0
        var sec: Long = 0 // нормально пересчитывается в счетчик подствляется
        object : CountDownTimer((timerVal), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val f = DecimalFormat("00"); //NumberFormat Used for formatting digit to be in 2 digits only
                year = (millisUntilFinished / (31104000000)) % 365;
                month = (millisUntilFinished / 2592000000) % 12;
                day = (millisUntilFinished / 86400000) % 30;
                hour = (millisUntilFinished / 3600000) % 24;
                min = (millisUntilFinished / 60000) % 60;
                sec = (millisUntilFinished / 1000) % 60;
                txtView2.setText(f.format(hour) + " : " + f.format(min) + " : " + f.format(sec));
                txtView.setText(f.format(year) + " : " + f.format(month) + " : " + f.format(day))
            }
            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                txtView.text = "Ура!!!";
            }
        }.start();
    }
}

/*
println("***********")
println("текущая дата : " + currentDate)
println("текущее время: " + currentTime)
println("дата Ч  :   " + dateCh)
println("время Ч :   " + timeCh)
println("************")
println("-----------------------")
println("Дней       = " + (periodDateDays-366)%31)
println("Период в мсек. = " + (periodTime))
println("Сумма в мс  = " + timerVal)
println("-----------------------")


*/
