package com.example.bazaar.api.types.Reponse

import com.google.gson.annotations.SerializedName

data class ProductsListResponse(
    @SerializedName("item_count")
    val itemCount: Int,

    @SerializedName ("products")
    val products: List<ProductResponse>,

    @SerializedName ("timestamp")
    val timeStamp: Long,

)
