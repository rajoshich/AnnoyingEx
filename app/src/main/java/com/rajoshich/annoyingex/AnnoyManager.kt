package com.rajoshich.annoyingex

import android.app.Application
import android.content.Context
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class AnnoyManager(private val context: Context) {

    private  var workManager = WorkManager.getInstance(context)

    fun startAnnoying() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()


        val workRequest = PeriodicWorkRequestBuilder<SendTextWorker>(20, TimeUnit.MINUTES)
            .setInitialDelay(5, TimeUnit.SECONDS)
            .setConstraints(constraints)
            .build()

        workManager.enqueue(workRequest)
    }


}