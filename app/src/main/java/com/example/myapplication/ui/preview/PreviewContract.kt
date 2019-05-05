package com.example.myapplication.ui.preview

import com.example.myapplication.model.Album
import com.example.myapplication.ui.base.BaseContract

class PreviewContract {
    interface View: BaseContract.View {
        fun showLoading()
        fun hideLoading()
        fun onLoadDataSuccess(list: List<Album>?)
        fun onLoadDataFailed(error: String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData()
    }
}