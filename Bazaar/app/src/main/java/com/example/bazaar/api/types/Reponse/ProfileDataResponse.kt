package com.example.bazaar.api.types.Reponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ProfileDataResponse(
    @SerializedName("username")
    val username: String,

    @SerializedName ("phone_number")
    val phone_number:String,

    @SerializedName ("email")
    val email: String,

    @SerializedName ("is_activated")
    val is_activated: String,

    @SerializedName("creation_time")
    var creation_time: Long,
)