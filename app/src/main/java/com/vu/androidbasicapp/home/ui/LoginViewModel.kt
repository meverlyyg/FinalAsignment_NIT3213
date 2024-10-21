package com.vu.androidbasicapp.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.androidbasicapp.home.data.LoginRequest
import com.vu.androidbasicapp.home.data.LoginResponse
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import com.vu.androidbasicapp.home.network.RestfulApiDevService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: RestfulApiDevRepositoryClass
) : ViewModel() {

    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> get() = _loginResponse

    private val _loginError = MutableLiveData<String>()
    val loginError: LiveData<String> get() = _loginError

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.loginUser(username, password)
                _loginResponse.postValue(response) // Update the response LiveData
            } catch (e: Exception) {
                _loginError.postValue(e.message) // Update the error LiveData
            }
        }
    }
}