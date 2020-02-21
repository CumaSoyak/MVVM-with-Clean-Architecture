package com.hepsiburadacase.di

import com.hepsiburadacase.BuildConfig
import com.local.di.localModule
import com.manager.di.managerModule
import com.remote.di.remoteModule

val appModule = listOf(
    remoteModule(BuildConfig.BASE_URL),
    localModule(BuildConfig.DB_NAME),
    managerModule,
    viewModelModule
)