package com.remote.service

import com.remote.model.campaigns.Campaigns
import retrofit2.http.GET
import retrofit2.http.Path

interface ICampaignsService {
    @GET("campaigns/{page}")
    suspend fun getCampaigns(@Path("page") page: Int): Campaigns


}