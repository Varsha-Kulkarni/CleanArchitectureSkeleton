package com.unravelled.core.data.sources.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.unravelled.core.domain.models.DummyData


/**
 * Created By Unravelled on 07/10/20
 */

@Dao
interface DummyDao {
    @Query("SELECT * FROM dummyTable")
    fun getDummyData(): List<DummyData>
}