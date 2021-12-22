package com.example.bazaar.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Reponse.ProfileDataResponse
import com.example.bazaar.api.types.Request.GetProductsRequest
import com.example.bazaar.api.types.Request.GetProfileRequest
import com.example.bazaar.api.types.Request.LoginRequest
import com.example.bazaar.api.types.Request.UpdateProfileRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileEditView(private val repository: MarketPlaceRepository) : ViewModel(){

    val TAG : String = javaClass.simpleName
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()

    lateinit var token: String
    //user data
    var userData: MutableLiveData<ProfileDataResponse> = MutableLiveData()

    lateinit var username: String
    lateinit var email: String
    lateinit var phone_number: String

    fun updateProfile() {
        token = App.sharedPreferences.getStringValue(SharedPreferencesManager.KEY_TOKEN, "0").toString()
        Log.d(TAG,"token: $token")
        if (token == "0"){
            Log.d(TAG, "NO TOKEN")
        }
        else{
            val requestBody = UpdateProfileRequest(phone_number,email, username)
            viewModelScope.launch {
                executeUpdateProfile(requestBody)
            }
        }
    }

    private suspend fun executeUpdateProfile(requestBody: UpdateProfileRequest) {
        try {
            val result = withContext(Dispatchers.IO) {
                repository.UpdateProfile(token,requestBody)
            }
            Log.d(TAG, "ProfileEditModel print - $requestBody, result: ${result.code} ${result.data[0]}, ${result.timestamp}")
            //userData.value = result.data[0]
            //App.sharedPreferences.putStringValue(SharedPreferencesManager.KEY_TOKEN, result.data[0].token)
            //App.sharedPreferences.putStringValue(SharedPreferencesManager.USERNAME_TOKEN, result.data[0].username)
            isSuccessful.value = true
            Log.d(TAG, "ProfileEditModel - profile response:")
        } catch (e: Exception) {
            Log.d(TAG, "ProfileEditModel - setProfile() failed withexception: ${e.message}")
            isSuccessful.value = false
        }
    }
}