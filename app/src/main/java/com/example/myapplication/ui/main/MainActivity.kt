package com.example.myapplication.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.di.component.DaggerActivityComponent
import com.example.myapplication.di.module.ActivityModule
import com.example.myapplication.ui.login.LoginFragment
import com.example.myapplication.ui.preview.PreviewFragment
import com.example.myapplication.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    MainContract.View,
    PreviewFragment.PreviewFragmentHandler,
    LoginFragment.LoginFragmentHandler {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun showErrorMessage(error: String) {
        Utils.showErrorDialog(this, error)
    }

    override fun onAuthenticationFinished() {
        Navigation
            .findNavController(this,R.id.fragment_container)
            .navigate(R.id.login_to_preview)
    }

}
