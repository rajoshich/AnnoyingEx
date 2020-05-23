package com.rajoshich.annoyingex

import android.app.Application

class AnnoyApp: Application() {

     lateinit var annoyManager: AnnoyManager
    private set

    lateinit var annoyNotificationManager: AnnoyNotificationManager
    private set

    override fun onCreate() {
        super.onCreate()

        annoyManager = AnnoyManager(this)
        annoyNotificationManager = AnnoyNotificationManager(this)
    }
}