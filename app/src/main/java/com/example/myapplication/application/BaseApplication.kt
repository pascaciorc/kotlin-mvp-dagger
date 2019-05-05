package com.example.myapplication.application

import android.app.Application
import com.example.myapplication.di.component.ApplicationComponent
import com.example.myapplication.di.component.DaggerApplicationComponent

class BaseApplication : Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    private fun setup() {
        component = DaggerApplicationComponent.create()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApplication private set
    }
}