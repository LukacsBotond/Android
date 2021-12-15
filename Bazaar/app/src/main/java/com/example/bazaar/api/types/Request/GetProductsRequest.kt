package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class GetProductsRequest (

    @SerializedName("token")
    var token: String,

    @SerializedName("limit")
    var limit: Int
)