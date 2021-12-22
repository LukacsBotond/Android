package com.example.bazaar.api.types.Reponse

import com.google.gson.annotations.SerializedName

class UpdatedProfileResponse (
    @SerializedName("code")
    var code: Int,

    @SerializedName("data")
    var data:Array<UpdatedDataResponse>,

    @SerializedName("timestamp")
    var timestamp: Long,
)