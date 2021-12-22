package com.example.bazaar.Support

import java.util.*

class TimestamptoDate {
    fun getDateTimeFromEpocLongOfSeconds(epoc: Long): String {
        return try {
            val netDate = Date(epoc)
            netDate.toString()
        } catch (e: Exception) {
            e.toString()
        }
    }
}