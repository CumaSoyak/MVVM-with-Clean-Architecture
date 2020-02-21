package com.hepsiburadacase.di

import com.hepsiburadacase.ui.campaignlist.CampaignListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CampaignListViewModel(get()) }
}