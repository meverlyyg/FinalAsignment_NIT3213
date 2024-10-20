package com.vu.androidbasicapp.home.network

import com.vu.androidbasicapp.home.data.AddObjectRequest
import com.vu.androidbasicapp.home.data.AddObjectResponse
import com.vu.androidbasicapp.home.data.ResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// API interface to match the endpoint
interface RestfulApiDevService {

    // method retrieves a list of all objects, which is a data class matching an individual object in the json response.
    @GET("objects")
    //Asynchronous Operation
    suspend fun getAllObjects(): List<ResponseItem>

    //retrieves a specific object by its ID. The @Path annotation is used to replace {id} in the URL with the actual ID
    // value passed as a parameter
    @GET("objects/{number}")
    suspend fun getSingleObject(@Path("number") id: Int): ResponseItem


    //This method creates a new object on the server. The @POST annotation specifies the HTTP method and path. The @Body
    //annotation is used to send the ApiRequest object as the request body.
    @POST("objects")
    suspend fun addObject(@Body requestBody: AddObjectRequest): AddObjectResponse
}