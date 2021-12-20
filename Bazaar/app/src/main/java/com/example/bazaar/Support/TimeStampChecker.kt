package com.example.bazaar.Support

import com.example.bazaar.App
import com.example.bazaar.Manager.SharedPreferencesManager

class TimeStampChecker {
    //true if token is still good
    fun check():Boolean{
        var timeInt:Long = 0
        var timeOutInt:Long = 0
        val currentTime = System.currentTimeMillis()
        var cTime = App.sharedPreferences.getStringValue(SharedPreferencesManager.CREATE_TIME_TOKEN, "0")
        var rTime = App.sharedPreferences.getStringValue(SharedPreferencesManager.TIMEOUT_TOKEN, "0")

        //TIMESTAMP checks
        if (cTime == null)
            cTime = "0"
        if (rTime == null)
            rTime = "0"
        try {
            timeInt = cTime.toLong()
        } catch (nfe: NumberFormatException) {
            return false
        }
        try {
            timeOutInt = rTime.toLong()
        } catch (nfe: NumberFormatException) {
            return false
        }

        //new phone
        if (timeInt == 0.toLong() || timeOutInt == 0.toLong()){
            return false
        }else{
            return (timeInt + timeOutInt) > currentTime
        }
    }
}