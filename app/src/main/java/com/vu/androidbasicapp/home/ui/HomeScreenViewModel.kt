package com.vu.androidbasicapp.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.androidbasicapp.home.data.AddObjectRequest
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//View Model : designed to store and manage UI-related data in a lifecycle-conscious way, allowing data to survive configuration
//changes. It also separate UI data management from UI controllers (Activities/Fragments), promoting cleaner architecture

@HiltViewModel
//@HiltViewModel: This annotation is used to inject dependencies into ViewModel classes. It allows Hilt to manage the lifecycle of the ViewModel and its dependencies. You annotate your
//ViewModel class with @HiltViewModel and use @Inject to request dependencies.
class HomeScreenViewModel @Inject constructor(private val repository: RestfulApiDevRepositoryClass): ViewModel() {

    //use the MutableStateFlow constructor, specifying the initial value and data type.
    val greetingText = MutableStateFlow("Hello Class")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())

    init {
        Log.d("nit3213", "HomeScreenViewModel ViewModel injected ")

        // The coroutine is launched within the scope of the ViewModel.
        // It will continue to run as long as the ViewModel is active.

        viewModelScope.launch {
            val result = repository.getAllObjectsData()
            delay(1000)
            updateGreetingTextState("Api has responded with the following items")
            delay(1000)
            apiResponseObjects.value = result
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}