package com.hepsiburadacase.ui.campaignlist

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hepsiburadacase.R
import com.hepsiburadacase.databinding.ActivityCampaignListBinding
import com.hepsiburadacase.ui.base.BindingActivity
import com.hepsiburadacase.ui.campaignlist.adapter.CampaignAdapter
import com.remote.model.campaigns.Campaigns
import com.remote.model.campaigns.ParentCampaign
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampaignListActivity : BindingActivity<ActivityCampaignListBinding>() {
    override val getLayoutBindId: Int
        get() = R.layout.activity_campaign_list

    private val viewModel by viewModel<CampaignListViewModel>()

    private val campaignAdapter by lazy { CampaignAdapter(arrayListOf()) }

    private var pageCount: Int = 1
    private var isLoading = true
    private var isLastPage = false
    private var mCampaigns: Campaigns = Campaigns()

    override fun initPresenter() {
        viewModel.setPresenter(this)
    }
    override fun initUI() {
        binding.vm = viewModel
        binding.lifecycleOwner = this

    }

    override fun initListener() {
        getCampaign()
        observerCampaign()
    }

    private fun getCampaign() {
        isLoading = false
        viewModel.getCampaign(pageCount)
    }

    private fun observerCampaign() {
        viewModel.campaignData.observe(this, Observer { loadCampaign(it) })
    }

    private fun loadCampaign(campaignData: Campaigns?) {
        mCampaigns.banners.addAll(campaignData!!.banners)
        mCampaigns.hotDeals.addAll(campaignData.hotDeals)
        setUpRecylerView()
        campaignAdapter.addData(processCampaignData(mCampaigns))
    }

    fun setUpRecylerView() {
        val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount =
                    (recyclerView.layoutManager as LinearLayoutManager).childCount
                val totalItemCount = (recyclerView.layoutManager as LinearLayoutManager).itemCount
                val firstVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                if (!isLastPage && !isLoading)
                    if (totalItemCount <= (firstVisibleItemPosition + visibleItemCount)) {
                        pageCount++
                        getCampaign()
                    }
            }
        }
        binding.rvCampaign.apply {
            setHasFixedSize(true)
            adapter = campaignAdapter
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }


    fun processCampaignData(campaignData: Campaigns?): ArrayList<ParentCampaign> {
        val listCampaign: ArrayList<ParentCampaign> = arrayListOf()

        val sizeHotDeals: Int = campaignData?.hotDeals!!.size
        val sizeBanners: Int = campaignData.banners.size

        val max = Math.max(sizeHotDeals, sizeBanners)
        val min = Math.min(sizeHotDeals, sizeBanners)

        for (index in 0 until max) {
            if (index < min) {
                listCampaign.add(campaignData.hotDeals[index])
                listCampaign.add(campaignData.banners[index])
            }
            if (index >= min) {
                if (sizeHotDeals > min) {
                    listCampaign.add(campaignData.hotDeals[index])
                }
                if (sizeBanners > min) {
                    listCampaign.add(campaignData.banners[index])
                }
            }
        }
        return listCampaign
    }

}
