package com.example.myapplication.di.module

import com.example.myapplication.api.ApiServiceInterface
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
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}