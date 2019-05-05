package com.example.myapplication.di.component

import com.example.myapplication.application.BaseApplication
import com.example.myapplication.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(baseApp: BaseApplication)
}