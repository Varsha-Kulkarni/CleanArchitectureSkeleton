package com.unravelled.core.data.sources.remote.api

import com.unravelled.core.domain.models.DummyData
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created By Unravelled on 06/10/20
 */
interface ApiService {

    /* Replace the api methods with actual REST Apis
    */

    @GET("details/")
    fun getDummys(): Single<List<DummyData>>

}