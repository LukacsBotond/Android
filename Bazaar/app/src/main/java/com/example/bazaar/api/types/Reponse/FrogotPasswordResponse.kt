package com.example.bazaar.api.types.Reponse

import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse (
    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String,

    )
{
    override fun toString(): String {
        return "LoginResponse(username='$username', email='$email')"
    }
}