package com.example.bazaar.api

import com.example.bazaar.api.types.Reponse.LoginResponse
import com.example.bazaar.api.types.Request.LoginRequest

class MarketPlaceRepository {

    suspend fun login(loginRequestBody: LoginRequest): LoginResponse {
        return RetrofitInstance.marketPlaceApiService.login(loginRequestBody)
    }
/*
    suspend fun getProducts(token: String): ProductsListResponse {
        return RetrofitInstance.marketPlaceApiService.getProducts(token)
    }

     */
}