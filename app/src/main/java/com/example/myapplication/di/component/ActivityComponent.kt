package com.example.myapplication.di.component

import com.example.myapplication.di.module.ActivityModule
import com.example.myapplication.ui.main.MainActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}