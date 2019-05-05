package com.example.myapplication.ui.preview

import com.example.myapplication.api.ApiServiceInterface
import com.example.myapplication.model.Album
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PreviewPresenter : PreviewContract.Presenter {
    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: PreviewContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: PreviewContract.View) {
        this.view = view
    }

    override fun loadData() {
        view.showLoading()
        val subscribe = api.getAlbumList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Album>? ->
                view.hideLoading()
                view.onLoadDataSuccess(list?.take(2))
            }, { error ->
                view.hideLoading()
                view.onLoadDataFailed(error.localizedMessage)
            })
        subscriptions.add(subscribe)
    }
}