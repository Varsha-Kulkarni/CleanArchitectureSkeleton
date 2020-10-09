package com.unravelled.core.data.sources.remote.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.unravelled.core.domain.models.DummyData
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Created By Unravelled on 06/10/20
 */
private const val BASE_URL = "https://my-json-server.typicode.com/typicode/demo/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getDummyData] method
 */
interface DummyDataApiService {
    /**
     * Returns a Coroutine [Deferred] [List] of [DummyData] which can be fetched with await() if
     * in a Coroutine scope.
     * The @GET annotation indicates that the "posts" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("posts")
    fun getDummyData():
    // The Coroutine Call Adapter allows us to return a Deferred, a Job with a result
            Deferred<List<DummyData>>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object DummyDataApi {
    val retrofitService : DummyDataApiService by lazy { retrofit.create(DummyDataApiService::class.java) }
}
