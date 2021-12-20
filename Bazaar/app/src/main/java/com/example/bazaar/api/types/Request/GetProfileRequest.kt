package com.example.bazaar.api.types.Request

import com.google.gson.annotations.SerializedName

data class GetProfileRequest (
    @SerializedName("username")
    var username: String,
)