package com.thindie.common.timemanagement

import java.time.format.DateTimeFormatter

interface TimeOperatorFormatter {

    fun getDatePickerFormat(): DateTimeFormatter
    fun getIsoFormat(): DateTimeFormatter
    fun getDayFormat(): DateTimeFormatter
    fun getDayShortFormat(): DateTimeFormatter
    fun getSimpleFormat(): DateTimeFormatter
    fun getMonthTitleFormat(): DateTimeFormatter
    fun getWeekDayFullFormat(): DateTimeFormatter
}