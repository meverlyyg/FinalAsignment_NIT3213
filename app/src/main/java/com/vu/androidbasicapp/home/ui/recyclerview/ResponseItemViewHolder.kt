package com.vu.androidbasicapp.home.ui.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.data.DetailItem

class ResponseItemViewHolder(view: View,private val navigationFunction: (DetailItem) -> Unit) : RecyclerView.ViewHolder(view) {

    private val destination: TextView = view.findViewById(R.id.itemDestinationtext)
    private val country: TextView = view.findViewById(R.id.CountryText)
    private val bestSeason: TextView = view.findViewById(R.id.bestSeasonText1)
    private val popularAttractionText: TextView = view.findViewById(R.id.popularAttractionText1)

    private val description: TextView = view.findViewById(R.id.descriptionText1)
    private val button: Button = view.findViewById(R.id.navigationButton)

//    Inflation: When the onCreateViewHolder method is called in the adapter, it inflates the item_layout.xml file to create a
//    View object. This View object is then passed to the ViewHolder constructor.
//    View Binding: Inside the ViewHolder constructor, the findViewById method is used to obtain a reference to the TextView
//    defined in the XML layout. This reference is stored in a private property (textView) within the ViewHolder class.
//    Data Binding: When the bind method is called, the textView is updated with the data passed to the method. This ensures
//    that the correct data is displayed in the TextView for each item in the RecyclerView.

    fun bind(item: DetailItem, isDetailScreen: Boolean) {
        destination.text = "Destination: ${item.destination}"
        country.text = "Country: ${item.country}"
        bestSeason.text = "Best Season: ${item.bestSeason}"
        popularAttractionText.text = "Popular Attraction: ${item.popularAttraction}"

        // Show description and button only in detail screen
        if (isDetailScreen) {
            description.text = item.destination
            description.visibility = View.VISIBLE
            button.visibility = View.VISIBLE
            button.setOnClickListener { navigationFunction(item) }
        } else {
            // Hide description and button in dashboard
            description.visibility = View.GONE
            button.visibility = View.VISIBLE // Show button in the home screen
            button.setOnClickListener { navigationFunction(item) } // Navigate to details
        }

    }
}
