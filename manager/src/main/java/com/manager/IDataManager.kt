package com.manager

import com.remote.model.campaigns.Campaigns
import com.remote.network.NetworkState
import kotlinx.coroutines.flow.Flow

interface IDataManager {

    fun getCampaigns(page:Int): Flow<NetworkState<Campaigns>>

}