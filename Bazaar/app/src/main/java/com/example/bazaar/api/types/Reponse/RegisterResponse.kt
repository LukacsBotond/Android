package com.example.bazaar.api.types.Reponse

import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    @SerializedName("code")
    var code: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("creation_time")
    var creation_time: Long,
){
    override fun toString(): String {
        return "RegisterResponse (code=$code, message= $message, creation_time=$creation_time)"
    }
}