package com.hepsiburadacase

import com.hepsiburadacase.ui.campaignlist.CampaignListActivity
import com.remote.DummyData
import com.remote.model.campaigns.Banners
import com.remote.model.campaigns.HotDeals
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CampaignTest {
    val data = DummyData.getCampaign()
    @Test
    fun lastDataCampaign() {
        assertTrue(CampaignListActivity().processCampaignData(data).get(15) is HotDeals)
    }

    @Test
    fun sizeCampaign() {
        assertEquals(data.banners.size, data.hotDeals.size)
    }
}
