package com.manager

import com.manager.base.BaseDataManager
import com.mg.local.dao.SoundDao
import com.remote.model.campaigns.Campaigns
import com.remote.network.NetworkState
import com.remote.service.ICampaignsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataManager(
    private val generalService: ICampaignsService
) : BaseDataManager(), IDataManager {

    override fun getCampaigns(page:Int): Flow<NetworkState<Campaigns>> =
        flow {
            emit(apiCall { generalService.getCampaigns(page) })
        }
}