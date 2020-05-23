package com.rajoshich.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var apiManager: APIManager
    lateinit var contentText: String
    lateinit var listOfMessages: Messages
    var text = "unable to retrieve message"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val annoyApp = (application as AnnoyApp)
        val annoyNotifManager = annoyApp.annoyNotificationManager
        apiManager = annoyApp.apiManager
        apiManager.getMessages({ msg ->
            listOfMessages = msg
            text = returnMessage(listOfMessages)
            intent.putExtra("txt", text)
        })

        annoyButton.setOnClickListener {
            annoyApp.annoyManager.startAnnoying()
            annoyNotifManager.postNotif()

        }

        blockButton.setOnClickListener {
            annoyApp.annoyManager.stopWork()
        }
    }

    private fun returnMessage(listOfMessages: Messages) :String {
           val index = Random.nextInt(listOfMessages.messages.size)
        var txt = listOfMessages.messages[index]
        return (txt)
    }
}
