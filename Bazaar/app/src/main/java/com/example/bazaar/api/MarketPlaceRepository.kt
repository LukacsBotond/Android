package com.example.bazaar.api

import android.util.Log
import com.example.bazaar.api.types.Reponse.ForgotPasswordResponse
import com.example.bazaar.api.types.Reponse.LoginResponse
import com.example.bazaar.api.types.Reponse.ProductsListResponse
import com.example.bazaar.api.types.Reponse.RegisterResponse
import com.example.bazaar.api.types.Request.ForgotPasswordRequest
import com.example.bazaar.api.types.Request.GetProductsRequest
import com.example.bazaar.api.types.Request.LoginRequest
import com.example.bazaar.api.types.Request.RegisterRequest

class MarketPlaceRepository {
    val TAG: String = javaClass.simpleName
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return RetrofitInstance.marketPlaceApiService.login(loginRequest)
    }

    suspend fun register(registerRequest: RegisterRequest):RegisterResponse{
        return RetrofitInstance.marketPlaceApiService.register(registerRequest)
    }

    suspend fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): ForgotPasswordResponse{
        return RetrofitInstance.marketPlaceApiService.forgotPassword(forgotPasswordRequest)
    }

    suspend fun getProducts(getProductsRequest: GetProductsRequest): ProductsListResponse {
        Log.d(TAG, "token = ${getProductsRequest.token}")
        return RetrofitInstance.marketPlaceApiService.getProducts(getProductsRequest.token)
    }

}