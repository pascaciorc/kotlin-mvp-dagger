package com.example.myapplication.ui.login

import com.example.myapplication.ui.base.BaseContract

class LoginContract {
    interface View: BaseContract.View {
        fun showLoading()
        fun hideLoading()
        fun onLoginSuccess()
        fun onLoginFailed(error: String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun doLogin()
    }
}