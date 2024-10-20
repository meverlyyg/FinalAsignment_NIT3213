package com.vu.androidbasicapp.home.network

import com.vu.androidbasicapp.home.data.TravelResponse
import retrofit2.http.GET

// API interface to match the endpoint
interface RestfulApiDevService {

    // method retrieves a list of all objects, which is a data class matching an individual object in the json response.
    @GET("dashboard/travel")
    //Asynchronous Operation
    suspend fun getAllObjects(): TravelResponse
}
