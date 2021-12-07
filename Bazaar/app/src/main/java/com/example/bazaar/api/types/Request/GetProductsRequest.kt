package com.example.bazaar.api.types.Request

data class GetProductsRequest (

    @SerializedName("token")
    var token: String,

    @SerializedName("limit")
    var limit: Int
)