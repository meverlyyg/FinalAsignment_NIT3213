package com.vu.androidbasicapp.home.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

// Complex data structures passed through by the navigation component needs to be of type @Parcelize
@Parcelize
data class DetailItem(
    @Json(name = "destination") val destination: String,
    @Json(name = "country")   val country: String,
    @Json(name = "bestSeason") val bestSeason: String,
    @Json(name = "popularAttraction") val popularAttraction: String,
    @Json(name = "description") val description: String
): Parcelable


//   @Json(name = "data") val dataSection: Map<String, String>?,
//    @Json(name = "id")   val id: String,
//    @Json(name = "name") val objectName: String

//   {
//        "id": "1",
//        "name": "Google Pixel 6 Pro",
//        "data": {
//            "color": "Cloudy White",
//            "capacity": "128 GB"
//        }

//{
//    "entities": [
//        {
//            "destination": "Paris",
//            "country": "France",
//            "bestSeason": "Spring",
//            "popularAttraction": "Eiffel Tower",
//            "description": "The capital of France, known for its art, fashion, gastronomy, and iconic landmarks."
//        },