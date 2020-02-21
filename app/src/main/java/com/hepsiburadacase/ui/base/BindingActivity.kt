package com.hepsiburadacase.ui.base

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<T : ViewDataBinding> : BaseActivity() {

    protected lateinit var binding: T
        private set

    @get:LayoutRes
    abstract val getLayoutBindId: Int

    override val layoutId: Int?
        get() = null

    override fun initBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutBindId)
    }

}