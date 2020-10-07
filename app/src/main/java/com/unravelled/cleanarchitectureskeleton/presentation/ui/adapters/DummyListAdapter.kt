package com.unravelled.cleanarchitectureskeleton.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unravelled.cleanarchitectureskeleton.R
import com.unravelled.core.domain.models.DummyData


/**
 * Created By Unravelled on 07/10/20
 */

class DummyListAdapter : RecyclerView.Adapter<DummyListViewHolder>(){

    private val dummyList = mutableListOf<DummyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyListViewHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.dummydata_list_row,parent,false)
        return DummyListViewHolder(view)
    }

    override fun onBindViewHolder(holder: DummyListViewHolder, position: Int) {
        val dummyData = dummyList[position]
        holder.run { showList(dummyData) }
    }

    override fun getItemCount(): Int = dummyList.size

}