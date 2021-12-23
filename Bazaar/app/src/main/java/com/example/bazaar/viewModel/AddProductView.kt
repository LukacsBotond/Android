package com.example.bazaar.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Request.AddProductRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddProductView (private val repository: MarketPlaceRepository) : ViewModel(){

    val TAG: String = javaClass.simpleName
    var token: MutableLiveData<String> = MutableLiveData()
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()

    lateinit var title: String
    lateinit var description: String
    lateinit var price_per_unit: String
    lateinit var units: String
    lateinit var is_active: String
    lateinit var rating: String
    lateinit var amount_type: String
    lateinit var price_per_type: String

    fun addProduct(){
        val requestBody = AddProductRequest(title,description,price_per_unit, units, is_active, rating, amount_type, price_per_type)
        viewModelScope.launch {
            executeAddProducts(requestBody)
        }
    }

    private suspend fun executeAddProducts(requestBody: AddProductRequest) {
        Log.d(TAG, "requestbody: $requestBody")
        val token = App.sharedPreferences.getStringValue(SharedPreferencesManager.KEY_TOKEN, "0") ?: return
        try {
            val result = withContext(Dispatchers.IO) {
                repository.addProduct(token, requestBody)
            }
            //Log.d(TAG, "items: ${result.creation}")
            isSuccessful.value = result.creation == "Successful"
        }catch (e: Exception){
            Log.d(TAG, "AddProductViewModel - executeAddProducts() failed withe exception: ${e.message}")
            isSuccessful.value = false
        }
    }
}