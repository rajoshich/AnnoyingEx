package com.rajoshich.annoyingex

import android.app.Application
import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

class AnnoyManager(private val context: Context) {

    private  var workManager = WorkManager.getInstance(context)

    companion object {
        const val ANNOY_TAG = "ANNOY_TAG"
    }

    fun startAnnoying() {
        if (!isAnnoyRunning()) {
            stopWork()
        }
            val constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .build()


            val workRequest = PeriodicWorkRequestBuilder<SendTextWorker>(20, TimeUnit.MINUTES)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .setConstraints(constraints)
                .addTag(ANNOY_TAG)
                .build()

            workManager.enqueue(workRequest)
        }


    private fun isAnnoyRunning(): Boolean {
        return when(workManager.getWorkInfosByTag(ANNOY_TAG).get().firstOrNull()?.state) {
            WorkInfo.State.ENQUEUED,
            WorkInfo.State.RUNNING -> true
               else -> false
            }
    }

    fun stopWork() {
        workManager.cancelAllWorkByTag(ANNOY_TAG)
    }


}