package eu.tutorials.mywishlistapp

import android.app.Application

class PasswordManagerApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}