package com.manager.di

import com.manager.DataManager
import com.manager.IDataManager
import org.koin.dsl.module

val managerModule = module {
    factory { DataManager(get()) as IDataManager }
}