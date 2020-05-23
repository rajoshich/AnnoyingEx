package com.rajoshich.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val annoyApp = (application as AnnoyApp)
        val annoyNotifManager = annoyApp.annoyNotificationManager
        annoyNotifManager.getMessages({ messages ->
            val listOfMessages = messages
        })

        annoyButton.setOnClickListener {

           annoyApp.annoyManager.startAnnoying()
            annoyNotifManager.postNotif()

    }



    }
}
