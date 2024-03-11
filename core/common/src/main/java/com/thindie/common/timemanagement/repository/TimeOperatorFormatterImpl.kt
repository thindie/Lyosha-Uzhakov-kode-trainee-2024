package com.thindie.common.timemanagement.repository

import com.thindie.common.timemanagement.TimeOperatorFormatter
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Named

internal class TimeOperatorFormatterImpl @Inject constructor(
    @Named("fullDate") private val fullDate: DateTimeFormatter,
    @Named("year") private val dayFormat: DateTimeFormatter,
    @Named("dayMonth") private val dayFormatShort: DateTimeFormatter,

    ) : TimeOperatorFormatter {

    override fun getFullDateFormat() = fullDate
    override fun getYearFormat() = dayFormat
    override fun getDayMonthFormat() = dayFormatShort


}