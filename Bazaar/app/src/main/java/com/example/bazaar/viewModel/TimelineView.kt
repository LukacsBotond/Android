package com.example.bazaar.viewModel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.R
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.api.types.Reponse.ProductResponse
import com.example.bazaar.api.types.Request.GetProductsRequest
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TimelineView (private val repository: MarketPlaceRepository) : ViewModel(){
    val TAG : String = javaClass.simpleName
    var list: MutableList<ProductResponse> = mutableListOf()
    var token: MutableLiveData<String> = MutableLiveData()
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()
    var filter:String = ""
    //var list: MutableList<ProductResponse> = generateList().toMutableList()
    var currentPosition: Int = 0

    init {
        list.clear()
        //getProducts()
    }

    fun addItem(item: ProductResponse) {
        list.add(item)
    }

    fun getItem(): ProductResponse {
        return list[currentPosition]
    }

    fun getProducts(){
        list.clear()
        token.value = App.sharedPreferences.getStringValue(SharedPreferencesManager.KEY_TOKEN, "0")
        if (token.value == "0" || token.value == null){
            Log.d(TAG, "NO TOKEN")
            list.clear()
        }
        else{
            val requestBody = GetProductsRequest(500, filter)
            viewModelScope.launch {
                executeGetProducts(requestBody)
            }
        }
    }


    private suspend fun executeGetProducts(requestBody: GetProductsRequest) {
        try {
            Log.d(TAG, "requestbody: $requestBody")
            val result = withContext(Dispatchers.IO) {
                Log.d(TAG, "TOKEN: ${token.value}")
                token.value?.let { repository.getProducts(it, requestBody) }
            }
            //TODO fix everything
            if (result != null) {
                Log.d(TAG, "items: ${result.itemCount}")
            }
            if (result != null) {
                Log.d(TAG, "items: ${result.timeStamp}")
            }
            result?.products?.forEach{
                Log.d(TAG, "items: $it")
                list.add(it)
            }
            isSuccessful.value = true
            //result.itemCount
        }catch (e: Exception){
            Log.d(TAG, "TimelineViewModel - executeGetProducts() failed withe xception: ${e.message}")
            isSuccessful.value = false
        }
    }
}