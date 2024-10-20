package com.vu.androidbasicapp.home.ui.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.data.ResponseItem

class ResponseItemViewHolder(view: View,private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.itemNametext)
    private val id: TextView = view.findViewById(R.id.itemIdText)
    private val details: TextView = view.findViewById(R.id.detailsText)
    private val button: Button = view.findViewById(R.id.navigationButton)

//    Inflation: When the onCreateViewHolder method is called in the adapter, it inflates the item_layout.xml file to create a
//    View object. This View object is then passed to the ViewHolder constructor.
//    View Binding: Inside the ViewHolder constructor, the findViewById method is used to obtain a reference to the TextView
//    defined in the XML layout. This reference is stored in a private property (textView) within the ViewHolder class.
//    Data Binding: When the bind method is called, the textView is updated with the data passed to the method. This ensures
//    that the correct data is displayed in the TextView for each item in the RecyclerView.

    fun bind(item: ResponseItem) {
        name.text = item.objectName
        id.text = "Id: " + item.id
        val showDetails = if (item.dataSection.isNullOrEmpty()) View.INVISIBLE else View.VISIBLE
        details.visibility = showDetails
        button.visibility = showDetails

        if (showDetails == View.VISIBLE) {
            button.setOnClickListener {
                navigationFunction(item)
            }
        }
    }
}
