package com.vu.androidbasicapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp: This annotation is applied to the Application class to trigger Hilt's code generation. It sets up the base application class as the root of the dependency graph. Every
//Android app using Hilt must have an Application class annotated with @HiltAndroidApp.
@HiltAndroidApp
class MyBaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("nit3213", "Application onCreate was called")
    }
}