package com.example.bazaar.api

import com.example.bazaar.api.types.Reponse.LoginResponse
import com.example.bazaar.api.types.Request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MarketPlaceApiService {

    @POST(BackendConstants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse
/*
    @GET(BackendConstants.GET_PRODUCT_URL)
    suspend fun getProducts(@Header(BackendConstants.HEADER_TOKEN) token: String): ProductsListResponse

 */
}