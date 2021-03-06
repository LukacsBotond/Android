package com.example.bazaar.api

import com.example.bazaar.api.types.Reponse.*
import com.example.bazaar.api.types.Request.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MarketPlaceApiService {

    @POST(BackendConstants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST(BackendConstants.REGISTER_URL)
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    @POST(BackendConstants.FORGOT_URL)
    suspend fun forgotPassword(@Body request: ForgotPasswordRequest) :ForgotPasswordResponse

    @GET(BackendConstants.GET_PRODUCT_URL)
    suspend fun getProducts(@Header(BackendConstants.HEADER_TOKEN) token: String, @Header(BackendConstants.HEADER_LIMIT) limit:Int, @Header(BackendConstants.HEADER_FILTER) filter:String): ProductsListResponse

    @GET(BackendConstants.GET_PROFILE_URL)
    suspend fun getProfile(@Header(BackendConstants.HEADER_USERNAME) username: String): ProfileResponse

    @POST(BackendConstants.UPDATE_PROFILE_URL)
    suspend fun updateProfile(@Header(BackendConstants.HEADER_TOKEN) token: String, @Body request: UpdateProfileRequest): UpdatedProfileResponse

    @POST(BackendConstants.ADD_PRODUCT_URL)
    suspend fun addProduct(@Header(BackendConstants.HEADER_TOKEN) token: String, @Body request: AddProductRequest): AddProductResponse



}