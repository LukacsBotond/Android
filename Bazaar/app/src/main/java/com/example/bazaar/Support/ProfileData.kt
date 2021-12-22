package com.example.bazaar.Support

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileData(
    val username: String,
    val phone_number:String,
    val email: String,
    val is_activated: String,
    var creation_time: Long,
) : Parcelable