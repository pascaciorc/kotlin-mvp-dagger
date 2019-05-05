package com.example.myapplication.di.component

import com.example.myapplication.di.module.FragmentModule
import com.example.myapplication.ui.preview.PreviewFragment
import dagger.Component

@Component(modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(previewFragment: PreviewFragment)
}