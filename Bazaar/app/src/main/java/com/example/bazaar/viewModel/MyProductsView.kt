package com.example.bazaar.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager
import com.example.bazaar.api.MarketPlaceRepository

class MyProductsView (private val repository: MarketPlaceRepository) : ViewModel() {
    private val TAG: String = javaClass.simpleName
    val factory = TimelineViewFactory(MarketPlaceRepository())
    val timelineView = TimelineView(MarketPlaceRepository())
    init{
        val username = App.sharedPreferences.getStringValue(SharedPreferencesManager.USERNAME_TOKEN, "0")
        timelineView.filter="{\"username\":\"$username\"}"
        Log.d(TAG, "filter: ${timelineView.filter}")
        timelineView.getProducts()
    }
}
