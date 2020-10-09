package com.unravelled.core.data.sources.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unravelled.core.data.sources.local.dao.DummyDataDao
import com.unravelled.core.domain.models.DummyData


/**
 * Created By Unravelled on 06/10/20
 */
@Database(entities = arrayOf(DummyData::class), version = 1,exportSchema = false)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun getDummyDataDao(): DummyDataDao
}