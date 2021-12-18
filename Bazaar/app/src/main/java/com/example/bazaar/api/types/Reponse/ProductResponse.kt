package com.example.bazaar.api.types.Reponse

import android.media.Image
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("rating")
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
){
    override fun toString(): String {
        return "Product (username = $username, title = $title, price per unit = $price_per_unit)"
    }
}
