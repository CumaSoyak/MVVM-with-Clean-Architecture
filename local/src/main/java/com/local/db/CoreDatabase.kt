package com.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.local.entity.SoundEntity
import com.mg.local.dao.SoundDao

@Database(
    entities = [SoundEntity::class],
    version = 2,
    exportSchema = false
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun soundDao(): SoundDao
}