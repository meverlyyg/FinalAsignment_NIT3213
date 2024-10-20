package com.vu.androidbasicapp.home.data

import com.vu.androidbasicapp.home.network.RestfulApiDevService
import javax.inject.Inject

class RestfulApiDevRepositoryClass @Inject constructor(
    private val apiService: RestfulApiDevService
) {
    suspend fun getAllObjectsData(): TravelResponse {
        return apiService.getAllObjects()
    }
}

    //Suspend functions enable the execution of blocking operations in Kotlin by allowing them
    // to be performed asynchronously without blocking the thread they're running on .

