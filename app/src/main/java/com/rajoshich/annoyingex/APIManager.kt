package com.rajoshich.annoyingex

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlin.random.Random

class APIManager(context: Context) {
    private lateinit var contentText: String
    private val queue: RequestQueue = Volley.newRequestQueue(context)
    private lateinit var listOfMessages: Messages

    fun getMessages() {
        val messagesURL = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/ex_messages.json"
        val req = StringRequest(
            Request.Method.GET, messagesURL,
            {
                val gson = Gson()
                listOfMessages = gson.fromJson(it, Messages::class.java)
//                onMessagesReady(listOfMessages)
//                val index = Random.nextInt(listOfMessages.messages.size)
//                contentText = listOfMessages.messages[index]
            },
            {
                contentText = "unable to retrieve message"
                    })
        queue.add(req)
    }

    fun returnMessages() :Messages {
        return listOfMessages
    }
}