package com.remote

import com.remote.model.campaigns.Banners
import com.remote.model.campaigns.Campaigns
import com.remote.model.campaigns.HotDeals
import com.remote.model.image.Image

object DummyData {

    fun getCampaign(): Campaigns {
        var campaigns = Campaigns()
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.hotDeals.add(HotDeals("HotDeals", "zaman"))
        campaigns.banners.add(Banners(Image(55, 55, "Banners")))
        campaigns.banners.add(Banners(Image(55, 55, "Banners")))
        campaigns.banners.add(Banners(Image(55, 55, "Banners")))
        campaigns.banners.add(Banners(Image(55, 55, "Banners")))
        campaigns.banners.add(Banners(Image(55, 55, "Banners")))
        campaigns.banners.add(Banners(Image(55, 55, "Banners")))

        return campaigns
    }
}