package com.example.myapplication.ui.login

import com.example.myapplication.api.ApiServiceInterface
import com.example.myapplication.model.Album
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter : LoginContract.Presenter {
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private val subscriptions = CompositeDisposable()
    private lateinit var view: LoginContract.View

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }

    override fun doLogin() {
        view.showLoading()
        val subscribe = api.getAlbumList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Album>? ->
                view.hideLoading()
                view.onLoginSuccess()
            }, { error ->
                view.hideLoading()
                view.onLoginFailed(error.localizedMessage)
            })
        subscriptions.add(subscribe)
    }
}