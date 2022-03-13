package com.xl.apmkit.work

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
object WorkKit {
    fun startApmWork(application: Application) {
//        val uploadWorkRequest: WorkRequest =
//            OneTimeWorkRequest.Builder(CollectSystemStateWork::class.java).build()
//        WorkManager.getInstance(application).enqueue(uploadWorkRequest)
    }
}