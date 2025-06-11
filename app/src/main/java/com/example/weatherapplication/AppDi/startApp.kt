package com.example.weatherapplication.AppDi

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CounterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CounterApp)
            modules(appModule)
        }
    }
}