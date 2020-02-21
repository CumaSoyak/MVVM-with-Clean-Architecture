package com.local.di

import androidx.room.Room
import com.local.db.CoreDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun localModule(dbName: String) = module {
    single {
        Room.databaseBuilder(androidApplication(), CoreDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<CoreDatabase>().soundDao() }

}