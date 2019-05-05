package com.example.myapplication.ui.main

import com.example.myapplication.ui.base.BaseContract

class MainContract {
    interface View: BaseContract.View {
        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(error: String)
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
    }
}