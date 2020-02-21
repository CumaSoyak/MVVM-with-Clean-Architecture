package com.remote.model.campaigns

import com.google.gson.annotations.SerializedName

data class Campaigns(
    @SerializedName("hotDeals") var hotDeals: ArrayList<HotDeals> = arrayListOf(),
    @SerializedName("banners") var banners: ArrayList<Banners> = arrayListOf()
)