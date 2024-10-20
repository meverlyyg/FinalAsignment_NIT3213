package com.vu.androidbasicapp.home.network

import com.vu.androidbasicapp.home.data.LoginRequest
import com.vu.androidbasicapp.home.data.LoginResponse
import com.vu.androidbasicapp.home.data.TravelResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// API interface to match the endpoint
interface RestfulApiDevService {

    // method retrieves a list of all objects, which is a data class matching an individual object in the json response.
    @POST("footscray/auth")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("dashboard/travel")
    //Asynchronous Operation
    suspend fun getAllObjects(): TravelResponse
}
