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
 //   lateinit var apiManager: APIManager
    lateinit var contentText: String
    lateinit var listOfMessages: Messages
    var text = "unable to retrieve message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val annoyApp = (application as AnnoyApp)
        val annoyNotifManager = annoyApp.annoyNotificationManager
     //   apiManager = annoyApp.apiManager


        annoyButton.setOnClickListener {
           annoyApp.annoyManager.startAnnoying()
            annoyNotifManager.postNotif()

    }

        blockButton.setOnClickListener {
            annoyApp.annoyManager.stopWork()
        }




        val queue: RequestQueue = Volley.newRequestQueue(this)
        fun getMessages() {
            val messagesURL =
                "https://raw.githubusercontent.com/echeeUW/codesnippets/master/ex_messages.json"
            val req = StringRequest(
                Request.Method.GET, messagesURL,
                {response ->
                    val gson = Gson()
                    listOfMessages = gson.fromJson(response, Messages::class.java)
//                onMessagesReady(listOfMessages)
                },
                {
                    Log.e("ERROR", it.networkResponse.toString())
                })
            queue.add(req)
        }


        fun returnMessage() {
            if (listOfMessages != null) {
                val index = Random.nextInt(listOfMessages.messages.size)
                text = listOfMessages.messages[index]
            }
        }
        annoyNotifManager.contentText  = text

    }
}
