package com.example.bazaar.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bazaar.api.MarketPlaceRepository

class LoginViewModelFactory(private val repository: MarketPlaceRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}