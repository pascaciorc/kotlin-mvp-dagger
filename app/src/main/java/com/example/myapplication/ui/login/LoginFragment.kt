package com.example.myapplication.ui.login

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.di.component.DaggerFragmentComponent
import com.example.myapplication.di.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_login.login_button
import kotlinx.android.synthetic.main.fragment_login.view.*
import javax.inject.Inject

class LoginFragment : Fragment(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter
    private lateinit var rootView: View
    var delegate: LoginFragmentHandler? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is LoginFragmentHandler) {
            delegate = context
        }
    }

    interface LoginFragmentHandler {
        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(error: String)
        fun onAuthenticationFinished()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_login, container, false)

        rootView.login_button.setOnClickListener {
            onLoginSuccess()
        }
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
        //presenter.loadData()
        //onLoadDataFailed("oops")
    }

    override fun showLoading() {
        delegate?.showLoading()
    }

    override fun hideLoading() {
        delegate?.hideLoading()
    }

    override fun onLoginSuccess() {
        delegate?.onAuthenticationFinished()
    }

    override fun onLoginFailed(error: String) {
        delegate?.showErrorMessage(error)
    }

}
