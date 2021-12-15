package com.example.bazaar.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel (private val repository: MarketPlaceRepository) : ViewModel(){

    val TAG: String = javaClass.simpleName

    lateinit var username: String
    lateinit var password: String

    var token: MutableLiveData<String> = MutableLiveData()
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()


    fun login() {
        val requestBody = LoginRequest(username, password)
        viewModelScope.launch {
            executeLogin(requestBody)
        }
    }

    private suspend fun executeLogin(requestBody: LoginRequest) {
        try {
            val result = withContext(Dispatchers.IO) {
                repository.login(requestBody)
            }
            token.value = result.token
            App.sharedPreferences.putStringValue(SharedPreferencesManager.KEY_TOKEN, result.token)
            App.sharedPreferences.putStringValue(SharedPreferencesManager.CREATE_TIME_TOKEN,result.creation_time.toString())
            App.sharedPreferences.putStringValue(SharedPreferencesManager.TIMEOUT_TOKEN, result.refresh_time.toString())
            isSuccessful.value = true
            Log.d(TAG, "LoginViewModel - login response: $result")
        } catch (e: Exception) {
            Log.d(TAG, "LoginViewModel - login() failed withexception: ${e.message}")
            isSuccessful.value = false
        }
    }

}