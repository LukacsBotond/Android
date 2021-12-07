package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class ForgotPasswordRequest (
    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String
)