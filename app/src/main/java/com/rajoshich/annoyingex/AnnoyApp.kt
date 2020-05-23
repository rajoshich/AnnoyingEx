package com.rajoshich.annoyingex

import android.app.Application

class AnnoyApp: Application() {

     lateinit var annoyManager: AnnoyManager
    private set

    lateinit var annoyNotificationManager: AnnoyNotificationManager
    private set

    lateinit var apiManager: APIManager

    override fun onCreate() {
        super.onCreate()
        apiManager = APIManager(this)

        annoyManager = AnnoyManager(this)
        annoyNotificationManager = AnnoyNotificationManager(this)
    }
}