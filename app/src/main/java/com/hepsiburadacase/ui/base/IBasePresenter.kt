package com.hepsiburadacase.ui.base

interface IBasePresenter {
    fun showLoading()
    fun hideLoading()
    fun onServerError(errorMessage: String, errorCode: Int)
    fun onServiceError(serviceMessage: String, errorCode: String)
    fun onServiceSuccess(serviceMessage: String, successCode: String)
}