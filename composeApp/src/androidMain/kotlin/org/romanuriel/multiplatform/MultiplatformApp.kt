package org.romanuriel.multiplatform

import android.app.Application

class MultiplatformApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}