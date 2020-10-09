package com.unravelled.cleanarchitectureskeleton.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unravelled.core.data.sources.remote.api.DummyDataApi
import com.unravelled.core.domain.models.DummyData
import kotlinx.coroutines.*

/**
 * Created By Unravelled on 07/10/20
 */
enum class DummyDataApiStatus { LOADING, ERROR, DONE }


class HomeViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<DummyDataApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<DummyDataApiStatus>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of DummyData
    // with new values
    private val _dummyData = MutableLiveData<List<DummyData>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val dummyData: LiveData<List<DummyData>>
        get() = _dummyData

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     * Call getDummyData() on init so we can display status immediately.
     */
    init {
        getDummyData()
    }

    /**
     * Gets information from the Dummy API Retrofit service and updates the
     * [DummyData] [List] [LiveData]. The Retrofit service returns a coroutine Deferred, which we
     * await to get the result of the transaction.
     */
    private fun getDummyData() {
        coroutineScope.launch {
            _status.value = DummyDataApiStatus.LOADING
            // this will run on a thread managed by Retrofit
            val getDummyDataDeferred  = DummyDataApi.retrofitService.getDummyData()
            try {
                _status.value = DummyDataApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                val listResult = getDummyDataDeferred.await()
                _status.value = DummyDataApiStatus.DONE
                _dummyData.value = listResult
            } catch (e: Exception) {
                _status.value = DummyDataApiStatus.ERROR
                _dummyData.value = ArrayList()
            }
        }
    }

    /**
     * When the [ViewModel] is finished, we cancel our coroutine [viewModelJob], which tells the
     * Retrofit service to stop.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
