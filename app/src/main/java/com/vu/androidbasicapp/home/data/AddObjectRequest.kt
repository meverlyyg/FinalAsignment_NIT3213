package com.vu.androidbasicapp.home.data

import com.squareup.moshi.Json

//Data class to match the Json response from API
data class AddObjectRequest(
    @Json(name = "data") val dataSection: Map<String, String>?,
    @Json(name = "name") val objectName: String
)