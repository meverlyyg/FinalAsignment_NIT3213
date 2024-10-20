package com.vu.androidbasicapp.home.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

// Complex data structures passed through by the navigation component needs to be of type @Parcelize
@Parcelize
data class ResponseItem(
    @Json(name = "data") val dataSection: Map<String, String>?,
    @Json(name = "id")   val id: String,
    @Json(name = "name") val objectName: String
): Parcelable