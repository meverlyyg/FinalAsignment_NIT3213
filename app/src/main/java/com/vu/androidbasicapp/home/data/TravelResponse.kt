package com.vu.androidbasicapp.home.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class TravelResponse(
    @Json(name = "entities") val entities: List<DetailItem>,
    @Json(name = "entityTotal") val entityTotal: Int
): Parcelable