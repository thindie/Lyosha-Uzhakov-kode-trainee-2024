package com.thindie.common.timemanagement

import java.time.LocalDateTime

interface TimeOperator {
    fun getCurrent(timeInMillis: Long): String
    fun getCurrent(timeInMillis: Long, pattern: String): String

    fun getCurrentLocalDateTime(timeInMillis: Long): LocalDateTime

    fun getCurrent(localDateTime: LocalDateTime, pattern: String): String

    fun getCurrent(): LocalDateTime

    fun getTimeFormatter(): TimeOperatorFormatter

    fun getMillisFromStringDate(date: String, pattern: String): Long
}