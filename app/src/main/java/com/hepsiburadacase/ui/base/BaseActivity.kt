package com.hepsiburadacase.ui.base

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.widget.dialog.LoadingLottieDialog


abstract class BaseActivity : AppCompatActivity(), IBasePresenter {

    @get:LayoutRes
    abstract val layoutId: Int?


    private val dialog: AlertDialog by lazy {
        LoadingLottieDialog.Builder().setContext(this)
            .setCancelable(false)
            .build()
    }

    protected abstract fun initPresenter()

    protected abstract fun initUI()

    protected abstract fun initListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutId != null) {
            setContentView(layoutId!!)
        } else {
            initBinding()
        }
        initPresenter()
        initUI()
        initListener()

        Log.d("LIFECYCLE", "onCreate")
    }

    open fun initBinding() {

    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "onResume")
    }

    override fun onServerError(errorMessage: String, errorCode: Int) {

    }

    override fun onServiceError(serviceMessage: String, errorCode: String) {

    }

    override fun onServiceSuccess(serviceMessage: String, successCode: String) {

    }

    override fun showLoading() {
        dialog.show()
    }

    override fun hideLoading() {
        dialog.dismiss()
    }

    override fun onPause() {
        super.onPause()
        dialog.dismiss()
    }

    override fun onStop() {
        super.onStop()
        dialog.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        dialog.dismiss()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}