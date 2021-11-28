package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("phone_number")
    var phone_number:String
)