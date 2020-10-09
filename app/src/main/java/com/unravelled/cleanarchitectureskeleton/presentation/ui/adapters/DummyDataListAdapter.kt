package com.unravelled.cleanarchitectureskeleton.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.unravelled.core.domain.models.DummyData
import androidx.recyclerview.widget.DiffUtil
import com.unravelled.cleanarchitectureskeleton.databinding.DummyDataListItemBinding


/**
 * Created By Unravelled on 07/10/20
 */

class DummyDataListAdapter : ListAdapter<DummyData, DummyDataListAdapter.DummyDataViewHolder>(DiffCallback) {

    /**
     * The DummyDataViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [DummyData] information.
     */
    class DummyDataViewHolder(private var binding: DummyDataListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dummyData: DummyData) {
            binding.dummyData = dummyData
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [DummyData]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<DummyData>() {
        override fun areItemsTheSame(oldItem: DummyData, newItem: DummyData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DummyData, newItem: DummyData): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): DummyDataViewHolder {
        return DummyDataViewHolder(DummyDataListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: DummyDataViewHolder, position: Int) {
        val dummyData = getItem(position)
        holder.bind(dummyData)
    }
}