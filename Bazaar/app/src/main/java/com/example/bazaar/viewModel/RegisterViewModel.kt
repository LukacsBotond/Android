package com.example.bazaar.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaar.MainActivity
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Request.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(private val repository: MarketPlaceRepository) : ViewModel() {
    val TAG: String = javaClass.simpleName

    lateinit var username: String
    lateinit var email: String
    lateinit var password: String
    lateinit var phone_number: String

    var token: MutableLiveData<String> = MutableLiveData()
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()


    fun register(){
        val requestBody = RegisterRequest(username, password,email,phone_number)
        viewModelScope.launch {
            executeRegister(requestBody)
        }
    }

    private suspend fun executeRegister(request: RegisterRequest){
        try{
            val result = withContext(Dispatchers.IO) {
                repository.register(request)
            }
            token.value = result.message
            isSuccessful.value = true
        }catch(e: Exception){
            isSuccessful.value = false
            Log.d(TAG,"RegisterViewModel-register() failed with exception: ${e.message}")
            //Toast.makeText(this,"RegisterViewModel-register() failed with exception:",Toast.LENGTH_SHORT).show()
        }
    }

}