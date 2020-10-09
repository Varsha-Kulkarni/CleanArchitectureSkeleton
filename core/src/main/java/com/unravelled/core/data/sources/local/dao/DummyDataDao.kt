package com.unravelled.core.data.sources.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.unravelled.core.domain.models.DummyData


/**
 * Created By Unravelled on 07/10/20
 */

@Dao
interface DummyDataDao {
    @Query("SELECT * FROM dummydata_table")
    fun getDummyData(): List<DummyData>
}