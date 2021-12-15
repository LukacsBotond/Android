package com.example.bazaar.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bazaar.api.MarketPlaceRepository

class RegisterViewModelFactory(private val repository: MarketPlaceRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegisterViewModel(repository) as T
    }
}