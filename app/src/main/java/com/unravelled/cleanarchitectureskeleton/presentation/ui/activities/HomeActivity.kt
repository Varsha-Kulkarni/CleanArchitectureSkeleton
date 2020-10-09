package com.unravelled.cleanarchitectureskeleton.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.unravelled.cleanarchitectureskeleton.R
import com.unravelled.cleanarchitectureskeleton.databinding.ActivityHomeBinding
import com.unravelled.cleanarchitectureskeleton.presentation.ui.adapters.DummyDataListAdapter
import com.unravelled.cleanarchitectureskeleton.presentation.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    private var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        initializeUi()
    }

    private fun initializeUi(){
        rvDummyDataList.layoutManager = LinearLayoutManager(this)
        rvDummyDataList.adapter = DummyDataListAdapter()
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding?.setLifecycleOwner(this)

        // Giving the binding access to the HomeViewModel
        binding?.homeViewModel = viewModel
    }
}