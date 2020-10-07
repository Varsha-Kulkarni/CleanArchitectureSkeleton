package com.unravelled.cleanarchitectureskeleton.presentation.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.unravelled.core.domain.models.DummyData
import kotlinx.android.synthetic.main.dummydata_list_row.view.*


/**
 * Created By Unravelled on 07/10/20
 */

class DummyListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun showList(dummyData: DummyData): Unit = with(itemView){
        tvName.text = dummyData.name
        tvDetails.text = dummyData.details
    }

}