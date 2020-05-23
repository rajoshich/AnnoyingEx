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

    private val queue: RequestQueue = Volley.newRequestQueue(context)


     fun getMessages(onMessagesReady: (Messages) -> Unit, onError: (() -> Unit)? = null) {
        val messagesURL =
            "https://raw.githubusercontent.com/echeeUW/codesnippets/master/ex_messages.json"
        val req = StringRequest(
            Request.Method.GET, messagesURL,
            { response ->
                val gson = Gson()
                val list = gson.fromJson(response, Messages::class.java)
                onMessagesReady(list)
            },
            {
                Log.i("ERROR", "error")
            })
        queue.add(req)
    }


}