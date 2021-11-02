package com.example.quizui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val imageResource:Int,
                 val text1: String,
                 var text2: String) : Parcelable