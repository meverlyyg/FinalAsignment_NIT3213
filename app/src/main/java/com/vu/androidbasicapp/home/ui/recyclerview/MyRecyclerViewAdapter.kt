package com.vu.androidbasicapp.home.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.data.ResponseItem

//designed to be flexible and reusable, allowing it to display any list of items of type YourDataType in a RecyclerView.
class MyRecyclerViewAdapter(private val dataList: MutableList<ResponseItem> = mutableListOf(), private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.Adapter<ResponseItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseItemViewHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.item_layout_restful_api_dev, parent, false)
        return ResponseItemViewHolder(view, navigationFunction = navigationFunction)
    }

    override fun onBindViewHolder(viewHolder: ResponseItemViewHolder, position: Int) {
        viewHolder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    // updateData method,ensures that the UI is refreshed whenever the data changes, making it a crucial part of dynamic and
    //responsive Android applications.

    fun setData(newDataList: List<ResponseItem>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}