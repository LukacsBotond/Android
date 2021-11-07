package com.example.quizui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val imageResource:Int,
                 val question: String,
                 val answer1:String,
                 val answer2:String,
                 val answer3:String,
                 val answer4:String) : Parcelable