package com.example.kmm_sample.android

import android.app.Application
import com.example.kmm_sample.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KmmApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KmmApplication)
            androidLogger()
            modules(module)
        }
    }

}