package com.example.bazaar.api

import android.util.Log
import com.example.bazaar.api.types.Reponse.*
import com.example.bazaar.api.types.Request.*

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
        return RetrofitInstance.marketPlaceApiService.getProducts(getProductsRequest.token)
    }

    suspend fun getProfile(getProfileRequest: GetProfileRequest): ProfileResponse {
        return RetrofitInstance.marketPlaceApiService.getProfile(getProfileRequest.username)
    }


}