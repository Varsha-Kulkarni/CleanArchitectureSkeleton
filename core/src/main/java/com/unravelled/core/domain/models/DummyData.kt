package com.unravelled.core.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created By Unravelled on 06/10/20
 */
@Entity(tableName = "dummyTable")
data class DummyData(

    @SerializedName("id")
    @PrimaryKey
    var id: Int = -1,

    @SerializedName("name")
    var name: String = "")