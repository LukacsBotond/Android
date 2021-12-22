package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class UpdateProfileRequest(
    @SerializedName("phone_number")
    var phone_number:String,

    @SerializedName("email")
    var email: String,

    @SerializedName("username")
    var username: String

)