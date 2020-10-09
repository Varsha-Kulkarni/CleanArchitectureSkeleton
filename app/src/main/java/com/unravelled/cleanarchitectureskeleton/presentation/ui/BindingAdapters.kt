package com.unravelled.cleanarchitectureskeleton.presentation.ui

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.unravelled.cleanarchitectureskeleton.R
import com.unravelled.cleanarchitectureskeleton.presentation.ui.adapters.DummyDataListAdapter
import com.unravelled.cleanarchitectureskeleton.presentation.viewmodels.DummyDataApiStatus
import com.unravelled.core.domain.models.DummyData


/**
 * Created By Unravelled on 08/10/20
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DummyData>?) {
    val adapter = recyclerView.adapter as DummyDataListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("dummyDataApiStatus")
fun bindStatus(statusImageView: ImageView, status: DummyDataApiStatus?) {
    when (status) {
        DummyDataApiStatus.LOADING -> {

            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DummyDataApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        DummyDataApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}