package com.thindie.common.timemanagement

import java.time.format.DateTimeFormatter

interface TimeOperatorFormatter {


    fun getFullDateFormat(): DateTimeFormatter
    fun getYearFormat(): DateTimeFormatter
    fun getDayMonthFormat(): DateTimeFormatter
}
