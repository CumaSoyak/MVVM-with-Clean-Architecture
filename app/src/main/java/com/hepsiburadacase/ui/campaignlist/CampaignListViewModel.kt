package com.hepsiburadacase.ui.campaignlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hepsiburadacase.ui.base.BaseViewModel
import com.hepsiburadacase.ui.base.IBasePresenter
import com.manager.IDataManager
import com.remote.model.campaigns.Campaigns
import com.remote.network.NetworkState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CampaignListViewModel(dataManager: IDataManager) : BaseViewModel<IBasePresenter>(dataManager) {
    val campaignData: MutableLiveData<Campaigns> = MutableLiveData()

    fun getCampaign(page: Int) = viewModelScope.launch {
        getPresenter()?.showLoading()
        dataManager.getCampaigns(page).collect { state ->
            when (state) {
                is NetworkState.Success -> {
                    getPresenter()?.hideLoading()
                    campaignData.value = state.response
                }
                is NetworkState.Error -> {
                    getPresenter()?.hideLoading()
                    getPresenter()?.onServiceError(state.exception.message, state.exception.message)
                }
            }
        }
    }
}