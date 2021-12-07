package com.example.bazaar.api.types.Reponse

data class ProductResponse(
    @Ser
    var rating: Double,

    @SerializedName("ammount_type")
    var ammountType: String,

    @SerializedName("price_type")
    var priceType: String,

    @SerializedName("product_id")
    var productId: String,

    @SerializedName("username")
    var username: String,

    @SerializedName("is_active")
    var isActive: Boolean,

    @SerializedName("price_per_unit")
    var price_per_unit: String,

    @SerializedName("units")
    var units: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("images")
    var images: List<Image>,

    @SerializedName("creation_type")
    var creationTime: Int,
)
