package com.example.bazaar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BackendConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val marketPlaceApiService: MarketPlaceApiService by lazy {
        retrofit.create(MarketPlaceApiService::class.java)
    }
}