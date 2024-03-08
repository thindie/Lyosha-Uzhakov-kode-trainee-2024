package com.thindie.common.timemanagement.repository

import com.thindie.common.timemanagement.TimeOperator
import com.thindie.common.timemanagement.TimeOperatorFormatter
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class TimeOperatorImpl @Inject constructor(
    private val timeOperatorFormatter: TimeOperatorFormatter,
    private val timeZone: TimeZone,
) :
    TimeOperator {
    override fun getCurrent(timeInMillis: Long): String {
        val localDateTime = getCurrentLocalDateTime(timeInMillis)
        return timeOperatorFormatter.getDatePickerFormat().format(localDateTime)
    }

    override fun getCurrent(timeInMillis: Long, pattern: String): String {
        return try {
            DateTimeFormatter.ofPattern(pattern).format(getCurrentLocalDateTime(timeInMillis))
        } catch (_: Exception) {
            "null with $pattern"
        }
    }

    override fun getCurrent(localDateTime: LocalDateTime, pattern: String): String {
        return try {
            DateTimeFormatter.ofPattern(pattern).format(localDateTime)
        } catch (_: Exception) {
            "null with $pattern"
        }
    }

    override fun getCurrent(): LocalDateTime {
        return getLocalDateTime(timeZone)
    }

    override fun getCurrentLocalDateTime(timeInMillis: Long): LocalDateTime {
        return LocalDateTime.ofInstant(instantFromMillis(timeInMillis), timeZone.toZoneId())
    }

    override fun getTimeFormatter(): TimeOperatorFormatter {
        return timeOperatorFormatter
    }


    private fun getLocalDateTime(timeZone: TimeZone): LocalDateTime {
        return LocalDateTime.ofInstant(Instant.now(), timeZone.toZoneId())
    }

    private fun instantFromMillis(millis: Long) = Date(millis).toInstant()
}