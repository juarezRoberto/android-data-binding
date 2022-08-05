package com.juarez.android.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int) {
    view.visibility = if (number == 0) View.GONE else View.VISIBLE
}

@BindingAdapter("data")
fun setRecyclerViewData(recyclerView: RecyclerView, list: List<Item>) {
    val adapter = recyclerView.adapter
    if (adapter is ItemAdapter) {
        adapter.submitList(list)
    }
}
