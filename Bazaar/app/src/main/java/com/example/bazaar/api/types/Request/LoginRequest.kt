package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String
)