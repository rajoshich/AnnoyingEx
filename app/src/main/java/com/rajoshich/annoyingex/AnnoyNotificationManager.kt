package com.rajoshich.annoyingex

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlin.random.Random

class AnnoyNotificationManager(private val context: Context) {
    private val notificationManagerCompat = NotificationManagerCompat.from(context)
    init {
        createNotificationChannel()
    }

    companion object {
        const val ANNOY_CHANNEL_ID = "ANNOY_CHANNEL_ID"
    }
      var contentText = "replace"


//    fun getText() : String {
//        if (contentText == null) {
//           text = ("unable to retrieve message")
//
//        } else {
//            text = contentText
//        }
//    }


    fun postNotif() {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(context, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT)


        val notification = NotificationCompat.Builder(context, ANNOY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_warning_black_24dp)
            .setContentTitle("Drake")
            .setContentText(contentText)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManagerCompat.notify(Random.nextInt(), notification)
    }

        private fun createNotificationChannel() {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Annoying texts"
                val descriptionText = "Thank you, next"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(ANNOY_CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                notificationManagerCompat.createNotificationChannel(channel)
            }
        }
    }

