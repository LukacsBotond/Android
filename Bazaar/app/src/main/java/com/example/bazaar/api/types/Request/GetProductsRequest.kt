package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class GetProductsRequest (
    @SerializedName("limit")
    var limit: Int,

    @SerializedName("filter")
    var filter: String
)