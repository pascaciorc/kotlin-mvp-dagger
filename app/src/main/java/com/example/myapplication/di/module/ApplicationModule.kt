package com.example.myapplication.di.module

import android.app.Application
import com.example.myapplication.application.BaseApplication
import com.example.myapplication.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApplication) {
    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}