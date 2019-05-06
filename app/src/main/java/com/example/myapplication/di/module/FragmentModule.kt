package com.example.myapplication.di.module

import com.example.myapplication.api.ApiServiceInterface
import com.example.myapplication.ui.login.LoginContract
import com.example.myapplication.ui.login.LoginPresenter
import com.example.myapplication.ui.preview.PreviewContract
import com.example.myapplication.ui.preview.PreviewPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    @Provides
    fun providePreviewPresenter(): PreviewContract.Presenter {
        return PreviewPresenter()
    }

    @Provides
    fun provideLoginPresenter(): LoginContract.Presenter {
        return LoginPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}