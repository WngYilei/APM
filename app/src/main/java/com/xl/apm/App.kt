package com.xl.apm

import android.app.Application
import com.xl.apmkit.work.WorkKit

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        WorkKit.startApmWork(this)
    }
}