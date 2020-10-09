package com.unravelled.core.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


/**
 * Created By Unravelled on 06/10/20
 */
//@Entity(tableName = "dummyTable")
//data class DummyData(
//
//    @PrimaryKey
//    val id: Double,
//    // used to map img_src from the JSON to imgSrcUrl in our class
//    @Json(name = "img_src") val details: String,
//    @Json(name = "type") val name: String,
//    val price: Double)

@Entity(tableName = "dummydata_table")
data class DummyData(
    @PrimaryKey
    val id: Double,
    // used to map "body" from the JSON to "details" in our class
//    @Json(name = "body") val details: String,
    @Json(name = "title") val name: String)