package com.garnegsoft.serbiandictionary

import android.app.Application
import android.util.Log

class MainApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		Log.e("i am here", "yes")
	}
}