package com.example.bazaar.api.types.Reponse

data class ProductsListResponse(
    @SerializedName ("item_count")
    val itemCount: Int,

    @SerializedName ("products")
    val products: List<ProductResponse>,

    @SerializedName ("timestamp")
    val timeStamp: Long,

)
