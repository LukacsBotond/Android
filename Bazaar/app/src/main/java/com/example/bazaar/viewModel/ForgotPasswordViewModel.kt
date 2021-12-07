package com.example.bazaar.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Request.ForgotPasswordRequest
import com.example.bazaar.api.types.Request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForgotPasswordViewModel(private val repository: MarketPlaceRepository) : ViewModel(){

    val TAG: String = javaClass.simpleName

    lateinit var username: String
    lateinit var email: String

    var token: MutableLiveData<String> = MutableLiveData()
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()


    fun forgotPassword() {
        val requestBody = ForgotPasswordRequest(username, email)
        viewModelScope.launch {
            executeForgotPassword(requestBody)
        }
    }

    private suspend fun executeForgotPassword(requestBody: ForgotPasswordRequest) {
        try {
            val result = withContext(Dispatchers.IO) {
                repository.forgotPassword(requestBody)
            }
            isSuccessful.value = true
            Log.d(TAG, "LoginViewModel - login response: $result")
        } catch (e: Exception) {
            Log.d(TAG, "LoginViewModel - login() failed withexception: ${e.message}")
            isSuccessful.value = false
        }
    }

}