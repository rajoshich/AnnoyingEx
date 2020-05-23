package com.rajoshich.annoyingex

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlin.random.Random

class APIManager(context: Context) {
//private lateinit var contentText: String
//    private val queue: RequestQueue = Volley.newRequestQueue(context)
//
//
//    private fun getMessages():Messages {
//        var listOfMessages: Messages
//        val messagesURL =
//            "https://raw.githubusercontent.com/echeeUW/codesnippets/master/ex_messages.json"
//        val req = StringRequest(
//            Request.Method.GET, messagesURL,
//            {response ->
//                val gson = Gson()
//                listOfMessages = gson.fromJson(response, Messages::class.java)
////                onMessagesReady(listOfMessages)
//            },
//            {
//                Log.e("ERROR", it.networkResponse.toString())
//            })
//        queue.add(req)
//    }
//
//
//    fun returnMessages() :String {
//        val list = getMessages()
//        if (list != null) {
//            val index = Random.nextInt(list.messages.size)
//
//            contentText = list.messages[index]
//            return contentText
//        } else {
//            return ("unable to retrieve message")
//
//    }
//    }
}