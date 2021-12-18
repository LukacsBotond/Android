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

    //var list: MutableList<ProductResponse> = generateList().toMutableList()
    var currentPosition: Int = 0

    init {
        getProducts()
    }

    fun addItem(item: ProductResponse) {
        list.add(item)
    }

    fun getItem(): ProductResponse {
        return list[currentPosition]
    }

    fun getProducts(){
        val tokenRead = App.sharedPreferences.getStringValue(SharedPreferencesManager.KEY_TOKEN, "0")
        if (tokenRead == "0" || tokenRead == null){
            Log.d(TAG, "NO TOKEN")
            list.clear()
        }
        else{
            val requestBody = GetProductsRequest(tokenRead,50)
            viewModelScope.launch {
                executeGetProducts(requestBody)
            }
        }
    }


    private suspend fun executeGetProducts(requestBody: GetProductsRequest) {
        try {
            val result = withContext(Dispatchers.IO) {
                Log.d(TAG, "TOKEN: ${requestBody.token}")
                repository.getProducts(requestBody)
            }
            //TODO fix everything
            Log.d(TAG, "items: ${result.itemCount}")
            Log.d(TAG, "items: ${result.timeStamp}")
            result.products.forEach{
                Log.d(TAG, "items: ${it.toString()}")
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