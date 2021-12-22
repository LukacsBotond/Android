package com.example.bazaar.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Reponse.ProfileDataResponse
import com.example.bazaar.api.types.Request.GetProfileRequest
import com.example.bazaar.api.types.Request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileEditView(private val repository: MarketPlaceRepository) : ViewModel(){
    /*
    val TAG : String = javaClass.simpleName
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()

    lateinit var token: String
    //user data
    var userData: MutableLiveData<ProfileDataResponse> = MutableLiveData()


    fun updateProfile() {
        val requestBody = GetProfileRequest(username)
        viewModelScope.launch {
            executeGetProfile(requestBody)
        }
    }

    private suspend fun executeGetProfile(requestBody: GetProfileRequest) {
        try {
            val result = withContext(Dispatchers.IO) {
                repository.getProfile(requestBody)
            }
            Log.d(TAG, "Profile = ${result.data[0]} ${result.data.size}")
            //Log.d(TAG, "Profile = ${result.data[1]}")
            userData.value = result.data[0]
            isSuccessful.value = true
            Log.d(TAG, "ProfileViewModel - profile response: ${result.data[0]}")
        } catch (e: Exception) {
            Log.d(TAG, "ProfileViewModel - getProfile() failed withexception: ${e.message}")
            isSuccessful.value = false
        }
    }

     */

}