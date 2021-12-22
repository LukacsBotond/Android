package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class AddProductRequest(
    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("price_per_unit")
    var price_per_unit: String,

    @SerializedName("is_active")
    var is_active: String,

    @SerializedName("rating")
    var rating: String,

    @SerializedName("amount_type")
    var amount_type: String,

    @SerializedName("price_per_type")
    var price_per_type: String,
)