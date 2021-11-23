package com.example.bazaar

import android.app.Application
import com.example.bazaar.Manager.SharedPreferencesManager

class App: Application() {

    companion object {
        lateinit var sharedPreferences: SharedPreferencesManager
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = SharedPreferencesManager(applicationContext)
    }

}