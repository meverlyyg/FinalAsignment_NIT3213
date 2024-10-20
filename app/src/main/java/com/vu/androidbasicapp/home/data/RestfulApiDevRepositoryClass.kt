package com.vu.androidbasicapp.home.data

import com.vu.androidbasicapp.home.network.RestfulApiDevService
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class RestfulApiDevRepositoryClass @Inject constructor(private val apiService: RestfulApiDevService
) {

    suspend fun loginUser(username: String, password: String):LoginResponse {
        val loginRequest = LoginRequest(username, password) // Create a LoginRequest object
        return apiService.login(loginRequest) // Call the login API
    }


    suspend fun getAllObjectsData(): TravelResponse {
        return apiService.getAllObjects()
    }
}

    //Suspend functions enable the execution of blocking operations in Kotlin by allowing them
    // to be performed asynchronously without blocking the thread they're running on .

