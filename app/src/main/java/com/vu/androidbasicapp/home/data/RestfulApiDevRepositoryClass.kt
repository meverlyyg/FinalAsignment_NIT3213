package com.vu.androidbasicapp.home.data

import com.vu.androidbasicapp.home.network.RestfulApiDevService
import javax.inject.Inject

class RestfulApiDevRepositoryClass @Inject constructor(private val restfulDevApiService: RestfulApiDevService) {

    //Suspend functions enable the execution of blocking operations in Kotlin by allowing them
    // to be performed asynchronously without blocking the thread they're running on .

    suspend fun getAllObjectsData() = restfulDevApiService.getAllObjects()

    suspend fun getSingleObject(id: Int) = restfulDevApiService.getSingleObject(id)

    suspend fun addSingleObject(item: AddObjectRequest) = restfulDevApiService.addObject(requestBody = item)
}