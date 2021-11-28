package com.example.bazaar.api

import com.example.bazaar.api.types.Reponse.LoginResponse
import com.example.bazaar.api.types.Reponse.RegisterResponse
import com.example.bazaar.api.types.Request.LoginRequest
import com.example.bazaar.api.types.Request.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MarketPlaceApiService {

    @POST(BackendConstants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST(BackendConstants.REGISTER_URL)
    suspend fun register(@Body request: RegisterRequest): RegisterResponse
/*
    @GET(BackendConstants.GET_PRODUCT_URL)
    suspend fun getProducts(@Header(BackendConstants.HEADER_TOKEN) token: String): ProductsListResponse

 */
}