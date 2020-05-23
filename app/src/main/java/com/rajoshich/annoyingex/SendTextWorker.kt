package com.rajoshich.annoyingex

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SendTextWorker(private val context: Context, workParams: WorkerParameters): Worker(context, workParams) {
    override fun doWork(): Result {
    Log.i("rc99", "annoy")
        return Result.success()
    }
}