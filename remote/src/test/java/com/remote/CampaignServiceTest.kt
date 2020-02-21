package com.remote

import com.remote.service.ICampaignsService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.inject

@RunWith(JUnit4::class)
class CampaignServiceTest : BaseServiceTest() {
    @Test
    fun `Get Campaigns`() = runBlocking {
        val campaignService by inject<ICampaignsService>()

        val response = campaignService.getCampaigns(0)

        Assert.assertEquals(0, response.banners.size)
        Assert.assertEquals(0, response.hotDeals.size)
    }
}
