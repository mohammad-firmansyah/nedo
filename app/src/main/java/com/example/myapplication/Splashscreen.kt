package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import java.util.*
import kotlin.system.exitProcess

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        supportActionBar?.hide()

        setContentView(R.layout.activity_splashscreen)


        delay(2000) {
            startActivity(Intent(this, MainMenuActivity::class.java))
            finish()
        }

    }

    private fun delay(time: Long, func: () -> Unit) {
        Handler(Looper.getMainLooper())
            .postDelayed({

                func()
            },time)
    }
}