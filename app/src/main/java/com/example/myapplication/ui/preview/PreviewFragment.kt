package com.example.myapplication.ui.preview

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup

import com.example.myapplication.R
import com.example.myapplication.di.component.DaggerFragmentComponent
import com.example.myapplication.di.module.FragmentModule
import com.example.myapplication.model.Album
import com.example.myapplication.utils.Utils
import kotlinx.android.synthetic.main.fragment_preview.*
import javax.inject.Inject

class PreviewFragment : Fragment(), PreviewContract.View {
    @Inject
    lateinit var presenter: PreviewContract.Presenter
    private lateinit var rootView: View
    var delegate: PreviewFragmentHandler? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is PreviewFragmentHandler) {
            delegate = context
        }
    }

    interface PreviewFragmentHandler {
        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(error: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_preview, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    private fun injectDependency() {
        val component = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()
        component.inject(this)
    }

    private fun initView() {
        presenter.loadData()
        //onLoadDataFailed("oops")
    }

    override fun showLoading() {
        delegate?.showLoading()
    }

    override fun hideLoading() {
        delegate?.hideLoading()
    }

    override fun onLoadDataSuccess(list: List<Album>?) {
        print(list)
    }

    override fun onLoadDataFailed(error: String) {
        delegate?.showErrorMessage(error)
    }

}
