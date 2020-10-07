package com.unravelled.cleanarchitectureskeleton.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.unravelled.cleanarchitectureskeleton.R
import com.unravelled.cleanarchitectureskeleton.presentation.ui.adapters.DummyListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initializeUi(){
        rvDummyDataList.layoutManager = LinearLayoutManager(this)
        rvDummyDataList.itemAnimator = DefaultItemAnimator()
        rvDummyDataList.adapter = DummyListAdapter()
    }

    private fun showLoading(isLoading: Boolean)
    {
        pullToRefresh.isRefreshing = isLoading
    }

    private fun setErrorVisibility(){
    }
}