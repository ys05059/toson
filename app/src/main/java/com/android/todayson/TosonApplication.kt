package com.android.todayson

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TosonApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }


}