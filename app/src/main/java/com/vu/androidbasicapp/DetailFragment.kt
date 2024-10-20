package com.vu.androidbasicapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    // Receive the Arguments in from the fragment
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailItem = args.detail

        // Display the detailItem information on this screen
        view.findViewById<TextView>(R.id.destinationText).text = detailItem.destination
        view.findViewById<TextView>(R.id.CountryTextView).text = detailItem.country
        view.findViewById<TextView>(R.id.bestSeasonText).text = detailItem.bestSeason
        view.findViewById<TextView>(R.id.popularAttractionText).text = detailItem.popularAttraction
        view.findViewById<TextView>(R.id.descriptionText).text = detailItem.description
    }
}


