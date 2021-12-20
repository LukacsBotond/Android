package com.example.bazaar.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bazaar.api.MarketPlaceRepository

class ProfileViewFactory(private val repository: MarketPlaceRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileView(repository) as T
    }
}