package com.rajoshich.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var apiManager: APIManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val annoyApp = (application as AnnoyApp)
        val annoyNotifManager = annoyApp.annoyNotificationManager
        apiManager = annoyApp.apiManager
        val texts = apiManager.returnMessages()
        val index = Random.nextInt(texts.messages.size)
        if (texts == null) {
            annoyNotifManager.contentText = "unable to retrieve message"
        }
        annoyNotifManager.contentText  = texts.messages[index]


        annoyButton.setOnClickListener {
           annoyApp.annoyManager.startAnnoying()
            annoyNotifManager.postNotif()

    }

        blockButton.setOnClickListener {
            annoyApp.annoyManager.stopWork()
        }



    }
}
