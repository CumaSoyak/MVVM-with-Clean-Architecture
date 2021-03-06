package com.hepsiburadacase.ui.base

import androidx.lifecycle.ViewModel
import com.manager.IDataManager
import java.lang.ref.WeakReference

abstract class BaseViewModel<P>(val dataManager: IDataManager) : ViewModel() {

    private lateinit var presenter: WeakReference<P>

    fun getPresenter(): P? {
        return presenter.get()
    }

    fun setPresenter(presenter: P) {
        this.presenter = WeakReference(presenter)
    }
}