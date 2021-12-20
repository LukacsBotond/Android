package com.example.bazaar.api.types.Reponse

import com.google.gson.annotations.SerializedName

class ProfileResponse (
    @SerializedName("code")
    var code: Int,

    @SerializedName("data")
    var data:Array<ProfileDataResponse>,

    @SerializedName("timestamp")
    var timestamp: Long,
)