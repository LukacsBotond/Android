package com.example.quizui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items (val imageResource:Int,
                 val Question: String,
                 var Answ1: String,
                 var Answ2: String,
                 var Answ3: String,
                 var Answ4: String) : Parcelable