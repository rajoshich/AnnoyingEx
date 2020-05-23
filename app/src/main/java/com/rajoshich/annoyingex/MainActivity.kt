package com.rajoshich.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
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
        apiManager.getMessages {
            listOfMessages = it
            text = returnMessage(listOfMessages)
        }

            intent.putExtra("txt", text)


        annoyButton.setOnClickListener {
            annoyApp.annoyManager.startAnnoying()
            annoyNotifManager.postNotif()

        }

        blockButton.setOnClickListener {
            annoyApp.annoyManager.stopWork()
        }

    }

    fun returnMessage(listOfMessages: Messages) :String {
        var txt:String
        if (listOfMessages != null) {
            val index = Random.nextInt(listOfMessages.messages.size)
            txt = listOfMessages.messages[index]
        } else {
            txt = "unable to retrieve message"
        }
        return (txt)
    }
}
