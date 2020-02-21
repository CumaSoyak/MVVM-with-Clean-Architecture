package com.hepsiburadacase.ui.campaignlist.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hepsiburadacase.R
import com.remote.model.campaigns.Banners
import com.remote.model.campaigns.HotDeals
import com.remote.model.campaigns.ParentCampaign
import com.util.extensions.calculateTime
import com.util.extensions.inflate
import com.util.extensions.load
import kotlinx.android.synthetic.main.item_campaign_generic_banner.view.*
import kotlinx.android.synthetic.main.item_campaign_hot_deal.view.*

class CampaignAdapter(var listCampaign: ArrayList<ParentCampaign>) :
    RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignViewHolder =
        CampaignViewHolder(parent.inflate(viewType))

    override fun getItemCount(): Int = listCampaign.size

    override fun getItemViewType(position: Int): Int {
        if (listCampaign.get(position) is HotDeals) {
            return R.layout.item_campaign_hot_deal
        } else {
            return R.layout.item_campaign_generic_banner
        }
    }

    override fun onBindViewHolder(holder: CampaignViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_campaign_hot_deal -> {
                return holder.bindHotDeals(listCampaign.get(position) as HotDeals, position)
            }
            R.layout.item_campaign_generic_banner -> {
                return holder.bindBanner(listCampaign.get(position) as Banners, position)
            }
        }
    }

    fun addData(listCampaign: ArrayList<ParentCampaign>) {
        this.listCampaign = listCampaign
    }

    class CampaignViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindHotDeals(hotDeal: HotDeals, position: Int) = with(itemView) {
            hotDeal.expirationDate?.calculateTime(context, tvTime)
            tvHotDealCount.text = "HotDeal # $position"
        }

        fun bindBanner(banner: Banners, position: Int) = with(itemView) {
            ivBanner.load(banner.image?.url)
            //todo    generic banner index  can be shown with  position value
        }
    }
}