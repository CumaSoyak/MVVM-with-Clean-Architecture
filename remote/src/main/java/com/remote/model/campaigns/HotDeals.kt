package com.remote.model.campaigns

import com.google.gson.annotations.SerializedName

data class HotDeals(
    @SerializedName("title") val title: String?,
    @SerializedName("expirationDate") val expirationDate: String?
) : ParentCampaign()