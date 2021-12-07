package com.example.bazaar.api

import com.example.bazaar.api.types.Reponse.ForgotPasswordResponse
import com.example.bazaar.api.types.Reponse.LoginResponse
import com.example.bazaar.api.types.Reponse.RegisterResponse
import com.example.bazaar.api.types.Request.ForgotPasswordRequest
import com.example.bazaar.api.types.Request.LoginRequest
import com.example.bazaar.api.types.Request.RegisterRequest

class MarketPlaceRepository {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return RetrofitInstance.marketPlaceApiService.login(loginRequest)
    }

    suspend fun register(registerRequest: RegisterRequest):RegisterResponse{
        return RetrofitInstance.marketPlaceApiService.register(registerRequest)
    }

    suspend fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): ForgotPasswordResponse{
        return RetrofitInstance.marketPlaceApiService.forgotPassword(forgotPasswordRequest)
    }
/*
    suspend fun getProducts(token: String): ProductsListResponse {
        return RetrofitInstance.marketPlaceApiService.getProducts(token)
    }
*/
}